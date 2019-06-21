package com.example.myapplication.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_public_liebiao;

import java.util.ArrayList;

public class Adaper_public_liebiao extends RecyclerView.Adapter<Adaper_public_liebiao.ViewHodler> {
    private ArrayList<Bean_public_liebiao.DataBean.DatasBean> nei;
    private Context context;

    public Adaper_public_liebiao(ArrayList<Bean_public_liebiao.DataBean.DatasBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme_public_liebiao, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.tv.setText(nei.get(position).getAuthor());
        holder.tv1.setText(nei.get(position).getTitle());
        holder.tv2.setText(nei.get(position).getNiceDate());

    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {

        private TextView tv;
        private TextView tv1;
        private TextView tv2;


        public ViewHodler(View itemView) {
            super(itemView);

            tv=itemView.findViewById(R.id.tv_public_name);
            tv1=itemView.findViewById(R.id.tv_public_title);
            tv2=itemView.findViewById(R.id.tv_public_shijian);
        }
    }
}
