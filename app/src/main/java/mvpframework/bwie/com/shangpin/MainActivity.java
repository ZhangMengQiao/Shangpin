package mvpframework.bwie.com.shangpin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mvpframework.bwie.com.shangpin.beam.ShowBean;
import mvpframework.bwie.com.shangpin.perstener.MainPerstener;
import mvpframework.bwie.com.shangpin.view.IMainActivity;


public class MainActivity extends AppCompatActivity implements IMainActivity {
    private MainPerstener mainPerstener;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPerstener = new MainPerstener(this);

        mainPerstener.doShow();
    }

    @Override
    public void onShow(List<ShowBean.DataBean> list) {
        MyAdapter myAdapter = new MyAdapter(this, list);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(myAdapter);
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
    }
}