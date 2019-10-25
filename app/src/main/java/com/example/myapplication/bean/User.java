package com.example.myapplication.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @anthor Liszt
 * @data 2019/10/22
 * Description
 */
public class User extends RealmObject {
    @PrimaryKey
    long userId;
    String name;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
