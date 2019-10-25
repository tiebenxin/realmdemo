package com.example.myapplication;

import com.example.myapplication.bean.Group;
import com.example.myapplication.bean.User;

import io.realm.Realm;

/**
 * @anthor Liszt
 * @data 2019/10/22
 * Description
 */
public class DaoTest {

    public void updateUser(User user) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(user);
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            realm.close();
        }
    }

    public void updateGroup(Group group) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(group);
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            realm.close();
        }
    }
}
