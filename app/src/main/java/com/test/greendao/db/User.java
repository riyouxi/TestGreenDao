package com.test.greendao.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by shanshan on 2018/5/15.
 */

@Entity(nameInDb = "user")
public class User {

    @Id
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "age")
    private Integer age;

    @Property(nameInDb = "test")
    private Integer test;

    @Property(nameInDb = "test2")
    private Integer test2;


    @Property(nameInDb = "test3")
    private Integer test3;


    @Generated(hash = 1126519746)
    public User(Long id, String name, Integer age, Integer test, Integer test2,
            Integer test3) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.test = test;
        this.test2 = test2;
        this.test3 = test3;
    }

    @Generated(hash = 586692638)
    public User() {
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public Integer getTest3() {
        return test3;
    }

    public void setTest3(Integer test3) {
        this.test3 = test3;
    }
}
