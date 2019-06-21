package com.example.myapplication.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_tixi;

import java.util.ArrayList;
import java.util.List;

public class Adapert_Tixi extends RecyclerView.Adapter<Adapert_Tixi.ViewHodler> {
    private ArrayList<Bean_tixi.DataBean> nei;
    private Context context;
    private String s;

    public Adapert_Tixi(ArrayList<Bean_tixi.DataBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme_tixi, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, final int position) {

        holder.tv.setText(nei.get(position).getName());
        List<Bean_tixi.DataBean.ChildrenBean> children = nei.get(position).getChildren();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < children.size(); i++) {
            StringBuffer append = sb.append(children.get(i).getName());
            s = String.valueOf(append);
        }
          holder.tv1.setText(s);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setos.Setos(position,s);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private TextView tv;
        private TextView tv1;
        public ViewHodler(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv_tixi_name);
            tv1=itemView.findViewById(R.id.tv_tixi_title);
        }
    }
    private Setos setos;

    public void setSetos(Setos setos) {
        this.setos = setos;
    }

    public interface Setos{
        void Setos(int p,String s);
    }
}
