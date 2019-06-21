package com.example.myapplication.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_Lei;

import java.util.ArrayList;

public class Adapert_jilu extends RecyclerView.Adapter<Adapert_jilu.ViewHodler> {
    private ArrayList<Bean_Lei> bean_lei;
    private Context context;

    public Adapert_jilu(ArrayList<Bean_Lei> bean_lei, Context context) {
        this.bean_lei = bean_lei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme_jilu, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.tv.setText(bean_lei.get(position).getTitle());
        holder.tv1.setText(bean_lei.get(position).getName());
        holder.tv2.setText(bean_lei.get(position).getGongong());
        holder.tv3.setText(bean_lei.get(position).getShijian());
    }

    @Override
    public int getItemCount() {
        return bean_lei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private TextView tv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHodler(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
        }
    }
}