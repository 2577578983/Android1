package com.example.myapplication.Dbhdler;

import com.example.ding.dao.Bean_LeiDao;
import com.example.ding.dao.DaoMaster;
import com.example.ding.dao.DaoSession;
import com.example.myapplication.apps.MyApplication;
import com.example.myapplication.model.http.bean.Bean_Lei;

import java.util.List;

public  class Dbhdler {
    private static Dbhdler dbhdler;
    private final Bean_LeiDao bean_leiDao;

    private Dbhdler(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getApp(), "stuzzz.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        bean_leiDao = daoSession.getBean_LeiDao();
    }
    public static Dbhdler getDbhdler() {
        if (dbhdler==null){
            synchronized (Dbhdler.class){
                if (dbhdler==null){
                    dbhdler=new Dbhdler();
                }
            }
        }
        return dbhdler;
    }
    public void insert(Bean_Lei bean_lei){
        if (Has()){

        }
        bean_leiDao.insert(bean_lei);

    }
    public void delete(Bean_Lei bean_lei){
        if (Has()){
            bean_leiDao.delete(bean_lei);
        }
    }
    public List<Bean_Lei> query(){
        List<Bean_Lei> list = bean_leiDao.queryBuilder().list();
        return list;
    }
    public List<Bean_Lei> queryName(String str){
        List<Bean_Lei> list = bean_leiDao.queryBuilder().where(Bean_LeiDao.Properties.Title.eq(str)).list();
        return list;
    }
    public boolean Has(){
        List<Bean_Lei> list = bean_leiDao.queryBuilder().list();
        if (list.size()>0&&list!=null){
            return true;
        }
        return false;
    }
}
