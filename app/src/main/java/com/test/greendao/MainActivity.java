package com.test.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.greendao.db.User;
import com.test.greendao.db.impl.UserProviderImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User();
        user.setName("bbcccdddd");
        user.setTest3(3332);
        UserProviderImpl userProvider = new UserProviderImpl();
        userProvider.insetOrUpdateUser(user);

        List<User> users = userProvider.getAllUser();
        if(users!=null){
            for(User user1: users){
                Log.e("TAG",user1.getTest3()+user1.getName());
            }
        }
//        userProvider.deleteUser(user);
//
//        List<User> users2 = userProvider.getAllUser();
//        if(users2!=null){
//            for(User user1: users2){
//                Log.e("TAG",user1.getId()+user1.getName());
//            }
//        }
    }
}
