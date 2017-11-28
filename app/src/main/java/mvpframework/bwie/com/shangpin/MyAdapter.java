package mvpframework.bwie.com.shangpin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import mvpframework.bwie.com.shangpin.beam.ShowBean;

/**
 * Created by Administrator on 2017/11/28.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context  context;
    private List<ShowBean.DataBean> list;
private LayoutInflater inflater;
    public MyAdapter(Context context, List<ShowBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHoder hoder1= (MyViewHoder) holder;
        ShowBean.DataBean dataBean = list.get(position);
        String images = dataBean.getImages();
        String[] split = images.split("\\|");
        ImageLoader.getInstance().displayImage(split[0],hoder1.im1);
        hoder1.tv1.setText(dataBean.getSubhead());
        hoder1.tv2.setText(dataBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHoder extends RecyclerView.ViewHolder{
        ImageView im1;
        TextView tv1 ;
        TextView tv2;
        public MyViewHoder(View itemView) {
            super(itemView);
              im1=itemView.findViewById(R.id.im1);
             tv1= itemView.findViewById(R.id.tv1);
             tv2= itemView.findViewById(R.id.tv2);
        }
    }
}
