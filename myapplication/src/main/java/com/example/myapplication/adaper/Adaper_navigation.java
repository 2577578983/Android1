package com.example.myapplication.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Fragment_Home_page.FlowLayout;
import com.example.myapplication.Fragment_Home_page.Fragment_navigation;
import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.Bean_Navigation;

import java.util.ArrayList;
import java.util.List;

public class Adaper_navigation extends RecyclerView.Adapter<Adaper_navigation.ViewHodler> {
    private ArrayList<Bean_Navigation.DataBean> nei;
    private List<Bean_Navigation.DataBean.ArticlesBean> mData;
    private final Context fragment_navigation;
    private TextView inflate;
    private String chapterName;
    private LayoutInflater mFrom;
    private List<Bean_Navigation.DataBean.ArticlesBean> articles;
    private TextView mTxt;
    public Adaper_navigation(ArrayList<Bean_Navigation.DataBean> nei, Context fragment_navigation) {
        this.nei = nei;
        this.fragment_navigation = fragment_navigation;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(fragment_navigation).inflate(R.layout.itme_navigation, null);
        ViewHodler hodler=new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, final int position) {

        holder.tv.setText(nei.get(position).getName());
        mFrom = LayoutInflater.from(fragment_navigation);
        if (nei != null && nei.size() > 0) {
            mData = nei.get(position).getArticles();
            for (int i = 0; i < mData.size(); i++) {
                mTxt = (TextView) mFrom.inflate(R.layout.flow_txt, null);
                mTxt.setText(mData.get(i).getTitle());
                holder.fl.addView(mTxt);
            }



                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setos.Setos(position);
                    }
                });

        }
    }

    @Override
    public int getItemCount() {
        return nei.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private FlowLayout fl;
        private TextView tv;

        public ViewHodler(View itemView) {
            super(itemView);
            fl=itemView.findViewById(R.id.fl);
            tv=itemView.findViewById(R.id.tv);
        }
    }
    private Setos setos;

    public void setSetos(Setos setos) {
        this.setos = setos;
    }

    public interface Setos{
        void Setos(int p);
    }
}
