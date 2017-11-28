package mvpframework.bwie.com.shangpin.beam;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.shangpin.model.IMainModel;
import mvpframework.bwie.com.shangpin.net.Api;
import mvpframework.bwie.com.shangpin.net.HttpUtils;
import mvpframework.bwie.com.shangpin.net.OnNetlitener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/11/28.
 */

public class MainModel implements IMainModel{
    private Handler handler=new Handler(Looper.getMainLooper());
    @Override
    public void doShow(final OnNetlitener<ShowBean> onNetlitener) {
        HttpUtils.getHttpUtils().doGet(Api.url, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetlitener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                final ShowBean showBean = new Gson().fromJson(string, ShowBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetlitener.onSuccess(showBean);
                    }
                });
            }
        });
    }
}
