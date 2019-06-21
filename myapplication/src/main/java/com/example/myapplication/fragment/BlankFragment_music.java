package com.example.myapplication.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adaper.MyAdapter;
import com.example.myapplication.model.http.bean.Song;
import com.example.myapplication.utils.MusicUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_music extends Fragment {


    private View view;
    private ListView mLv;
    private List<Song> list;
    private MediaPlayer mplayer;
    private int currentposition=0;
    public BlankFragment_music() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment_yinyue, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mLv = (ListView) inflate.findViewById(R.id.lv);
        list = MusicUtils.getMusicData(getActivity());
        MyAdapter adapter = new MyAdapter(getActivity(), list);
        mLv.setAdapter(adapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                musicplay(currentposition);
            }
        });


    }

    private void musicplay(int position) {
        try {


            mplayer.reset();
            mplayer.setDataSource(list.get(position).getPath());
            mplayer.prepare();
            mplayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
