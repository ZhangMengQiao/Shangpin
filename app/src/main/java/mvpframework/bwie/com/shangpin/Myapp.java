package mvpframework.bwie.com.shangpin;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2017/11/28.
 */

public class Myapp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration iamge=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(iamge);
    }
}
