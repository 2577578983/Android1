package com.example.myapplication.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;

import java.util.ArrayList;

public class WanAndorid_adaper extends RecyclerView.Adapter<WanAndorid_adaper.ViewHolder> {
    private ArrayList<Bean_wanAndorid.DataBean.DatasBean> android;
    private Context context;

    public WanAndorid_adaper(ArrayList<Bean_wanAndorid.DataBean.DatasBean> android, Context context) {
        this.android = android;
        this.context = context;
    }

    public void setAndroid(ArrayList<Bean_wanAndorid.DataBean.DatasBean> android) {
        this.android = android;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme, null);
        ViewHolder holder=new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(android.get(position).getId()+"");
        holder.tv1.setText(android.get(position).getLink());
        Glide.with(context).load(android.get(position).getEnvelopePic()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv1;
        public ViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
