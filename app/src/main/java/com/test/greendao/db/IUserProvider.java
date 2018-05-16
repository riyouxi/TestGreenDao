package com.test.greendao.db;

import java.util.List;

/**
 * Created by shanshan on 2018/5/15.
 */

public interface IUserProvider {

    public User getUserById(long id);

    public List<User> getAllUser();

    public boolean insetOrUpdateUser(User user);

    public boolean deleteUser(User user);
}
