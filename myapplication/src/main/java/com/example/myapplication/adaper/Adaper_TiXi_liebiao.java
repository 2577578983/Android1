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
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;

import java.util.ArrayList;

public class Adaper_TiXi_liebiao extends RecyclerView.Adapter<Adaper_TiXi_liebiao.ViewHodler> {
    private ArrayList<Bean_tixi_liebiao.DataBean.DatasBean> nei;
    private Context context;

    public Adaper_TiXi_liebiao(ArrayList<Bean_tixi_liebiao.DataBean.DatasBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme_tixi_liebiao, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.tv.setText(nei.get(position).getChapterName());
        holder.tv1.setText(nei.get(position).getTitle());
        holder.tv2.setText(nei.get(position).getNiceDate());
        Glide.with(context).load(R.mipmap.ic_launcher).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv1;
        private TextView tv2;
        public ViewHodler(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv_title);
            tv2=itemView.findViewById(R.id.tv_shi);
        }
    }
}
