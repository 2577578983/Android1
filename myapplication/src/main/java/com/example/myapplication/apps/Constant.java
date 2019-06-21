package com.example.myapplication.apps;

import java.io.File;

public class Constant {

    public static final String Base_Url = "https://www.wanandroid.com/";


    //网络缓存的地址
    public static final String PATH_DATA = MyApplication.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/ShiXun";

}
