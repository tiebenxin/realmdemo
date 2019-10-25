package com.example.myapplication.bean;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @anthor Liszt
 * @data 2019/10/22
 * Description
 */
public class Group extends RealmObject {
    @PrimaryKey
    String gid;
    RealmList<User> users;
    RealmList<Member> members;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public RealmList<User> getUsers() {
        return users;
    }

    public void setUsers(RealmList<User> users) {
        this.users = users;
    }

    public RealmList<Member> getMembers() {
        return members;
    }

    public void setMembers(RealmList<Member> members) {
        this.members = members;
    }
}
