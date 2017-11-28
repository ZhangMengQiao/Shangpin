package mvpframework.bwie.com.shangpin.model;

import mvpframework.bwie.com.shangpin.beam.ShowBean;
import mvpframework.bwie.com.shangpin.net.OnNetlitener;

/**
 * Created by Administrator on 2017/11/28.
 */

public interface IMainModel {
    public void doShow(OnNetlitener<ShowBean> onNetlitener);
}
