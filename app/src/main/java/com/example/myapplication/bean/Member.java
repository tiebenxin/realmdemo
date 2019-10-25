package com.example.myapplication.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @anthor Liszt
 * @data 2019/10/22
 * Description
 */
public class Member extends RealmObject {
    @PrimaryKey
    String memberId;
    long userId;
    String gid;
    String name;

    public void init(String gid, long uid) {
        memberId = gid + uid;
    }

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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }
}
