package com.danshi.danhanxiang.RealmObject;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by 20939 on 2016/12/14.
 */
public class Contact extends RealmObject {
    private String name;
    private RealmList<Email> emails;

    private class Email extends RealmObject {
        private String address;
        private boolean active;
    }
}
