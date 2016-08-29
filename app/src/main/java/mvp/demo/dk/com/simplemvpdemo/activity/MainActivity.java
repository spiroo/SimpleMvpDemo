package mvp.demo.dk.com.simplemvpdemo.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import mvp.demo.dk.com.simplemvpdemo.R;
import mvp.demo.dk.com.simplemvpdemo.data.Computer;
import mvp.demo.dk.com.simplemvpdemo.presenter.ComputerPresenter;
import mvp.demo.dk.com.simplemvpdemo.task.TaskContract;

public class MainActivity extends Activity implements TaskContract.View {

    private ListView listView;

    private Button btnCreate;

    private ComputerPresenter computerPresenter;

    private ProgressDialog mLoadingDialog;
    ArrayAdapter<Computer> arrayAdapter;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computerPresenter = new ComputerPresenter(this);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, computerPresenter.getComputerList());
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerPresenter.addRandomComputer();
            }
        });

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                computerPresenter.removeComputer(position);
                showToast("销毁了一台电脑！");
            }
        });
    }

    @Override
    public void showCreatingComputer() {
        mLoadingDialog = new ProgressDialog(this);
        mLoadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mLoadingDialog.setMessage("工厂正在生产电脑");
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.show();
    }

    @Override
    public void showComputerCountChange() {
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoComputer() {
        findViewById(R.id.noComputer).setVisibility(View.VISIBLE);
    }

    @Override
    public void showFactoryBusy() {
        showToast("工厂繁忙，请稍后再试！");
    }

    @Override
    public void showCreatedComputer() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
        mLoadingDialog = null;
        showToast("新生产出一台电脑！");
    }

    @Override
    public void hideNoComputer() {
        findViewById(R.id.noComputer).setVisibility(View.GONE);
    }

    private void showToast(String string) {
        if (toast == null) {
            toast = Toast.makeText(this, string, Toast.LENGTH_SHORT);
        }else{
            toast.setText(string);
        }
        toast.show();
    }
}
