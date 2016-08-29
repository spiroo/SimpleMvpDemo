package mvp.demo.dk.com.simplemvpdemo.task;

import java.util.ArrayList;

import mvp.demo.dk.com.simplemvpdemo.data.Computer;

/**
 * Created by DK-dong on 2016/8/23.
 */

public interface TaskContract {

    interface View {

        void showCreatingComputer();


        void showComputerCountChange();

        void showNoComputer();

        void showFactoryBusy();

        void showCreatedComputer();

        void hideNoComputer();
    }

    interface Presenter {

        void addComputer(Computer computer);

        void removeComputer(Computer computer);

        void removeComputer(int index);

        ArrayList<Computer> getComputerList();

        void addRandomComputer();
    }
}
