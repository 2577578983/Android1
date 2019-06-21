package com.example.myapplication.adaper;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.Fragment_Home_page.FlowLayout;
import com.example.myapplication.Propert.Ui_acivity.Acivity_search;
import com.example.myapplication.R;
import com.example.myapplication.model.http.bean.SearchBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private final Acivity_search acivity_search;
    private ArrayList<SearchBean> mList;

    public SearchAdapter(Acivity_search acivity_search, ArrayList<SearchBean> mList) {
        this.acivity_search = acivity_search;
        this.mList = mList;
    }

    public void setmList(ArrayList<SearchBean> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flowlayout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List<SearchBean.DataBean> list = mList.get(i).getData();
        for (int j = 0; j < list.size(); j++) {
            TextView flow = (TextView) View.inflate(acivity_search, R.layout.flow_txt, null);

            final String title = list.get(j).getName();
            flow.setText(title);

            flow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(acivity_search, title, Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.mfl.addView(flow);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FlowLayout mfl;
        public ViewHolder(View itemView) {
            super(itemView);
               mfl=itemView.findViewById(R.id.fl);
        }
    }
}
