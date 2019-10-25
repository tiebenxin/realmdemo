package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.bean.Group;
import com.example.myapplication.bean.Member;
import com.example.myapplication.bean.User;

import io.realm.Realm;
import io.realm.RealmList;

public class MainActivity extends AppCompatActivity {
    /*
     * hexString: a name contains emoji, produced in mobile phone,converted to hexString, by stringToHex16String()
     * */
    String hexString = "F09F8D8AE4B880E58FB6E4B98BE7A78B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testUpdateUser();
        testUpdateGroup();
        testUpdateGroupMember();
    }


    public void testUpdateUser() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            User user = realm.createObject(User.class, 10000);
            user.setName(hexStrToString(hexString));
            realm.commitTransaction();
            realm.close();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            realm.close();
        }

    }

    public void testUpdateGroup() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            Group group = realm.createObject(Group.class, "0001");
            RealmList<User> members = new RealmList<>();
            for (int i = 0; i < 3; i++) {
                User user = realm.createObject(User.class, i);
                user.setName(hexStrToString(hexString) + i);
                members.add(user);
            }
            group.setUsers(members);
            realm.commitTransaction();
            realm.close();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
            realm.close();
        }
    }

    public void testUpdateGroupMember() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
//            Group group = realm.createObject(Group.class, "0002");
            Group group = new Group();
            RealmList<Member> members = new RealmList<>();
            for (int i = 0; i < 3; i++) {
                Member user = new Member();
                user.init(group.getGid(), i);
                user.setName(hexStrToString(hexString) + i);
                members.add(user);
            }
            group.setMembers(members);
            realm.copyToRealm(group);
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
