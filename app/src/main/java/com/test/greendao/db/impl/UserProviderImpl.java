package com.test.greendao.db.impl;

import com.test.greendao.db.DBHelper;
import com.test.greendao.db.IUserProvider;
import com.test.greendao.db.User;

import java.util.List;

/**
 * Created by shanshan on 2018/5/15.
 */

public class UserProviderImpl implements IUserProvider {
    @Override
    public User getUserById(long id) {
        return  DBHelper.getHelper().queryById(User.class,id);
    }

    @Override
    public List<User> getAllUser() {
        return DBHelper.getHelper().queryForAll(User.class);
    }

    @Override
    public boolean insetOrUpdateUser(User user) {
        return DBHelper.getHelper().saveEntity(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return DBHelper.getHelper().deleteEntity(user);
    }


}
