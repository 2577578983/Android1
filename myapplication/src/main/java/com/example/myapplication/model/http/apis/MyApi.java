package com.example.myapplication.model.http.apis;


import com.example.myapplication.model.http.bean.Bean_Navigation;
import com.example.myapplication.model.http.bean.Bean_banner;
import com.example.myapplication.model.http.bean.Bean_collect;
import com.example.myapplication.model.http.bean.Bean_collect_liebiao;
import com.example.myapplication.model.http.bean.Bean_landing;
import com.example.myapplication.model.http.bean.Bean_liebiao;
import com.example.myapplication.model.http.bean.Bean_public;
import com.example.myapplication.model.http.bean.Bean_public_liebiao;
import com.example.myapplication.model.http.bean.Bean_quxiao;
import com.example.myapplication.model.http.bean.Bean_quxiaos;
import com.example.myapplication.model.http.bean.Bean_registered;
import com.example.myapplication.model.http.bean.Bean_shanchu;
import com.example.myapplication.model.http.bean.Bean_shouye;
import com.example.myapplication.model.http.bean.Bean_tiaomu;
import com.example.myapplication.model.http.bean.Bean_tixi;
import com.example.myapplication.model.http.bean.Bean_tixi_liebiao;
import com.example.myapplication.model.http.bean.Bean_wanAndorid;
import com.example.myapplication.model.http.bean.SearchBean;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface MyApi {
    @GET("article/list/0/json")
    Flowable<Bean_wanAndorid> getIndexData();

    @POST("user/login")
    @FormUrlEncoded
    Flowable<Bean_landing> getdata_landing(@Field("username") String name,@Field("password") String passwrod);

    @POST("user/register")
    @FormUrlEncoded
    Flowable<Bean_registered> getdata_registered(@Field("username") String name,@Field("password") String passwrod,
                                                 @Field("repassword") String repassword);

    //https://www.wanandroid.com/article/list/0/json
    @GET("article/list/0/json")
    Flowable<Bean_shouye> getdata_shouye();

    //https://www.wanandroid.com/banner/json
    @GET("banner/json")
    Flowable<Bean_banner> getdata_banner();

    //https://www.wanandroid.com//hotkey/json
    @GET("hotkey/json")
    Flowable<SearchBean> getdata_liushi();

    //https://www.wanandroid.com/project/tree/json 项目条目
    @GET("project/tree/json")
    Flowable<Bean_tiaomu> getdata_tiao();

    //https://www.wanandroid.com/project/list/1/json?cid=294  列表
    @GET()
    Flowable<Bean_liebiao> getdata(@Url String url);

    //https://www.wanandroid.com/tree/json 体系
    @GET("tree/json")
    Flowable<Bean_tixi> getdta_tixi();

    //https://www.wanandroid.com/article/list/0/json?cid=60 //体系列表
    @GET()
    Flowable<Bean_tixi_liebiao> getdata_tixi_liebiao(@Url String ui);

    //https://wanandroid.com/wxarticle/chapters/json  //公众号
    @GET("wxarticle/chapters/json")
    Flowable<Bean_public> getdata_public();

    //https://wanandroid.com/wxarticle/list/408/1/json //公众号列表
    @GET()
    Flowable<Bean_public_liebiao> getdata_public_liebiao(@Url String page);


    //https://www.wanandroid.com/navi/json   //导航
    @GET("navi/json")
    Flowable<Bean_Navigation> getdata_Navigation();

    //https://www.wanandroid.com/ 收藏
    @POST("lg/collect/{page}/json")
    Flowable<Bean_collect> getdata_collect(@Path("page") int ur);

    //https://www.wanandroid.com/lg/collect/list/0/json    //收藏列表
    @GET("lg/collect/list/0/json")
    Flowable<Bean_collect_liebiao> getdata_collect_liebiao();

    //https://www.wanandroid.com/lg/uncollect_originId/2333/json
    @POST("lg/uncollect_originId/{page}/json")
    Flowable<Bean_quxiao> getdata_quxiao(@Path("page") int page);

    //https://www.wanandroid.com/lg/uncollect/2805/json
    @POST("lg/uncollect/{page}/json")
    @FormUrlEncoded
    Flowable<Bean_quxiaos> getdata_quxiaos(@Path("page") int page, @Field("originId") int a);

}