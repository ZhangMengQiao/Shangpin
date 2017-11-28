package mvpframework.bwie.com.shangpin.net;

/**
 * Created by Administrator on 2017/11/28.
 */

public interface OnNetlitener<T> {
    public void onSuccess(T t);
    public void onFailure(Exception e);
}
