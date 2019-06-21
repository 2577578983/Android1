package com.example.myapplication.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_collect_liebiao;

import java.util.ArrayList;

public class Adaper_collect extends RecyclerView.Adapter<Adaper_collect.ViewHodler> {
    private ArrayList<Bean_collect_liebiao.DataBean.DatasBean> nei;
    private Context context;

    public Adaper_collect(ArrayList<Bean_collect_liebiao.DataBean.DatasBean> nei, Context context) {
        this.nei = nei;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.itme_text, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler holder, final int position) {
        holder.tv.setText(nei.get(position).getTitle());
        holder.tv1.setText(nei.get(position).getAuthor());
        holder.tv2.setText(nei.get(position).getChapterName());
        holder.tv3.setText(nei.get(position).getNiceDate());
        final Bean_collect_liebiao.DataBean.DatasBean datasBean = nei.get(position);
      //  holder.checkBox.setChecked(datasBean.isIsbox());
        if (datasBean!=null){
            holder.checkBox.setChecked(true);
        }

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setOn.SetOn(position,isChecked);
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
        private TextView tv2;
        private TextView tv3;
        private CheckBox checkBox;
        public ViewHodler(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv_zuozhe);
            tv2=itemView.findViewById(R.id.tv_fenlei);
            tv3=itemView.findViewById(R.id.tv_shijian);
            checkBox=itemView.findViewById(R.id.cb);
        }
    }
    private SetOn setOn;

    public void setSetOn(SetOn setOn) {
        this.setOn = setOn;
    }

    public interface SetOn{
        void SetOn(int p, boolean checkBox);
    }
}
