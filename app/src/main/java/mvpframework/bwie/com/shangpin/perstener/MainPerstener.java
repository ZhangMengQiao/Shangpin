package mvpframework.bwie.com.shangpin.perstener;

import java.util.List;

import mvpframework.bwie.com.shangpin.beam.MainModel;
import mvpframework.bwie.com.shangpin.beam.ShowBean;
import mvpframework.bwie.com.shangpin.model.IMainModel;
import mvpframework.bwie.com.shangpin.net.OnNetlitener;
import mvpframework.bwie.com.shangpin.view.IMainActivity;

/**
 * Created by Administrator on 2017/11/28.
 */

public class MainPerstener {
    private IMainModel iMainModel;
    private IMainActivity iMainActivity;

    public MainPerstener(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel=new MainModel();
    }
    public void doShow(){
        iMainModel.doShow(new OnNetlitener<ShowBean>() {
            @Override
            public void onSuccess(ShowBean showBean) {
                List<ShowBean.DataBean> data = showBean.getData();
                iMainActivity.onShow(data);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
