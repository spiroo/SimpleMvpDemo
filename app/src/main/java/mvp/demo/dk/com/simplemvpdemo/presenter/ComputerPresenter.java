package mvp.demo.dk.com.simplemvpdemo.presenter;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

import mvp.demo.dk.com.simplemvpdemo.data.Computer;
import mvp.demo.dk.com.simplemvpdemo.data.ComputerFactory;
import mvp.demo.dk.com.simplemvpdemo.task.TaskContract;

/**
 * Created by su on 2016/6/22.
 */
public class ComputerPresenter implements TaskContract.Presenter {

    private final ComputerFactory computerFactory;
    private final TaskContract.View operationView;

    private static final long createComputerTime = 2000;
    private static final int msgWhat = 0x102;


    public ComputerPresenter(@NonNull TaskContract.View operationView) {
        this.computerFactory = new ComputerFactory();
        this.operationView = operationView;
    }

    @Override
    public void addComputer(Computer computer) {
        operationView.showComputerCountChange();
        if (mHandler.hasMessages(msgWhat)) {
            operationView.showFactoryBusy();
            return;
        }
        Message message = new Message();
        message.what = msgWhat;
        message.obj = computer;
        mHandler.sendMessageDelayed(message, createComputerTime);
        operationView.showCreatingComputer();
    }

    @Override
    public void removeComputer(Computer computer) {

    }

    @Override
    public void removeComputer(int index) {
        computerFactory.removeComputer(index);
        if (computerFactory.getComputerCounts() <= 0) {
            operationView.showNoComputer();
        }
        operationView.showComputerCountChange();
    }

    @Override
    public ArrayList<Computer> getComputerList() {
        ArrayList<Computer> computers = computerFactory.getComputers();
        if (computers.isEmpty()){
            operationView.showNoComputer();
        }
        return computers;
    }

    @Override
    public void addRandomComputer() {
        addComputer(new Computer("Dell Inspiron", 4000 + new Random().nextInt(1000), "5439"));
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            computerFactory.addComputer((Computer) msg.obj);
            operationView.showCreatedComputer();
            operationView.showComputerCountChange();
            operationView.hideNoComputer();
        }
    };
}
