package com.example.myapplication.fragment;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myapplication.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment_video extends Fragment {


    private View view;
    private JCVideoPlayerStandard mVideoplayer;
    private VideoView mVideoView;

    public BlankFragment_video() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment_video, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mVideoView = (VideoView) inflate.findViewById(R.id.videoView);
        String path = Environment.getExternalStorageDirectory().getPath()+"/20180730.mp4";
        mVideoView.setVideoPath(path);
        MediaController mediaController = new MediaController(getActivity());
        //MediaController mediaController = new MediaController(this);
        mVideoView.setMediaController(mediaController);
        mVideoView.requestFocus();
    }

}
