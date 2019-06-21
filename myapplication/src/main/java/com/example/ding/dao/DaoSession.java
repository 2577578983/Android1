package com.example.ding.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.myapplication.model.http.bean.Bean_Lei;

import com.example.ding.dao.Bean_LeiDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bean_LeiDaoConfig;

    private final Bean_LeiDao bean_LeiDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bean_LeiDaoConfig = daoConfigMap.get(Bean_LeiDao.class).clone();
        bean_LeiDaoConfig.initIdentityScope(type);

        bean_LeiDao = new Bean_LeiDao(bean_LeiDaoConfig, this);

        registerDao(Bean_Lei.class, bean_LeiDao);
    }
    
    public void clear() {
        bean_LeiDaoConfig.clearIdentityScope();
    }

    public Bean_LeiDao getBean_LeiDao() {
        return bean_LeiDao;
    }

}