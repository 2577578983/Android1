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
import com.example.myapplication.model.http.bean.Bean_liebiao;

import java.util.ArrayList;

public class Adapert_liebiao extends RecyclerView.Adapter<Adapert_liebiao.ViewHodler> {
    private ArrayList<Bean_liebiao.DataBean.DatasBean> nei;
    private Context context;

    public Adapert_liebiao(ArrayList<Bean_liebiao.DataBean.DatasBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme_tableau, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, final int position) {
        holder.tv_name.setText(nei.get(position).getChapterName());
        holder.tv_title.setText(nei.get(position).getTitle());
        Glide.with(context).load(nei.get(position).getEnvelopePic()).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setoncli.Setoncli(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv_name;
        private TextView tv_title;
        public ViewHodler(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_title=itemView.findViewById(R.id.tv_title);
        }
    }
    private Setoncli setoncli;

    public void setSetoncli(Setoncli setoncli) {
        this.setoncli = setoncli;
    }

    public interface Setoncli{
        void Setoncli(int p);
    }
}
