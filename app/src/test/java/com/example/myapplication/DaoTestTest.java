package com.example.myapplication;

import com.example.myapplication.bean.Group;
import com.example.myapplication.bean.User;

import org.junit.Test;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * @anthor Liszt
 * @data 2019/10/22
 * Description
 */
public class DaoTestTest {
    /*
     * hexString: a name contains emoji, String convert to hexString , by stringToHex16String()
     * */
    String hexString = "F09F8D8AE4B880E58FB6E4B98BE7A78B";


    @Test
    public void testUpdateUser() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            User user = realm.createObject(User.class);
            user.setUserId(0);
            user.setName(hexStrToString(hexString));
            realm.commitTransaction();
            realm.close();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            realm.close();
        }

    }

    @Test
    public void testUpdateGroup() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            Group group = realm.createObject(Group.class);
            group.setGid("0001");
            RealmList<User> members = new RealmList<>();
            for (int i = 0; i < 3; i++) {
                User user = realm.createObject(User.class);
                user.setUserId(i);
                user.setName(hexStrToString(hexString) + i);
                members.add(user);
            }
            realm.commitTransaction();
            realm.close();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            realm.close();
        }
    }

    /*
     * String to hexString
     * */
    public String stringToHex16String(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

    /*
     * hexString to String
     * */
    public String hexStrToString(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

}