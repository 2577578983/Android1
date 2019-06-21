package com.example.myapplication.adaper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_banner;
import com.example.myapplication.model.http.bean.Bean_shouye;
import com.example.myapplication.utils.SpUtil;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Adapert_shouye extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Bean_shouye.DataBean.DatasBean> nei;
    private ArrayList<Bean_banner.DataBean> ban;
    private Context context;

    public Adapert_shouye(ArrayList<Bean_shouye.DataBean.DatasBean> nei, ArrayList<Bean_banner.DataBean> ban, Context context) {
        this.nei = nei;
        this.ban = ban;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType==0){
            View inflate = View.inflate(context, R.layout.itme_text, null);
            ViewHodler1 hodler1=new ViewHodler1(inflate);
            return hodler1;
        }else if (viewType==1) {
            View inflate = View.inflate(context, R.layout.banner_tu, null);
            ViewHodler2 hodler2 = new ViewHodler2(inflate);
            return hodler2;
        }
        if (viewType == 0) {
            View inflate = View.inflate(context, R.layout.itme, null);
            ViewHodler1 hodler1 = new ViewHodler1(inflate);
            return hodler1;
        } else {
            View inflate = View.inflate(context, R.layout.banner_tu, null);
            ViewHodler2 hodler2=new ViewHodler2(inflate);
            return hodler2;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
            int a=0;
            final ViewHodler1 hodler1= (ViewHodler1) holder;
            if (ban.size()>0){
                a=position-1;
            }
            final Bean_shouye.DataBean.DatasBean bean = nei.get(a);

            hodler1.tv.setText(nei.get(a).getTitle());
            hodler1.tv_zuozhe.setText(nei.get(a).getAuthor());
            hodler1.tv_gongzhonghao.setText(nei.get(a).getSuperChapterName());
            hodler1.tv_shijian.setText(nei.get(a).getNiceDate());
            hodler1.cb.setChecked(bean.isCollect());
            hodler1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOnclick.SetOnclick(position);
                }
            });


            hodler1.cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (hodler1.cb.isChecked()){
                        //SpUtil.getParam("isChecked", 0);
                        bean.setCollect(true);
                        chbaox.Chbaox(position,true);
                    }else{
                        bean.setCollect(false);
                        chbaox.Chbaox(position,false);
                    }
                }
            });

        }else{
            ViewHodler2 hodler2= (ViewHodler2) holder;
            hodler2.ba.setImages(ban).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Bean_banner.DataBean ba= (Bean_banner.DataBean) path;
                    Glide.with(context).load(ba.getImagePath()).into(imageView);
                }
            }).start();
            hodler2.ba.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    seto.Seto(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (ban.size()>0){
            return nei.size()+1;
        }else{
            return nei.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (ban.size()>0&&position==0){
            return 1;
        }else{
            return 0;
        }

    }
    class ViewHodler1 extends RecyclerView.ViewHolder{
        private TextView tv;
        private TextView tv_zuozhe;
        private TextView tv_gongzhonghao;
        private TextView tv_shijian;
        private CheckBox cb;
        public ViewHodler1(View itemView) {
            super(itemView);
            cb=itemView.findViewById(R.id.cb);
            tv=itemView.findViewById(R.id.tv);
            tv_zuozhe=itemView.findViewById(R.id.tv_zuozhe);
            tv_gongzhonghao=itemView.findViewById(R.id.tv_fenlei);
            tv_shijian=itemView.findViewById(R.id.tv_shijian);
        }
    }
    class ViewHodler2 extends RecyclerView.ViewHolder{
        private Banner ba;
        public ViewHodler2(View itemView) {
            super(itemView);
            ba=itemView.findViewById(R.id.ban);
        }
    }
    private SetOnclick setOnclick;

    public void setSetOnclick(SetOnclick setOnclick) {
        this.setOnclick = setOnclick;
    }

    public interface SetOnclick{
        void SetOnclick(int p);
    }
    private Seto seto;

    public void setSeto(Seto seto) {
        this.seto = seto;
    }

    public interface Seto{
        void Seto(int p);
    }
    private Chbaox chbaox;

    public void setChbaox(Chbaox chbaox) {
        this.chbaox = chbaox;
    }

    public interface Chbaox{
        void Chbaox(int p,boolean cb);
    }
}
