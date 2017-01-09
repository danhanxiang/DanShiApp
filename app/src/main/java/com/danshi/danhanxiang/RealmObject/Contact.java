package com.danshi.danhanxiang.RealmObject;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by 20939 on 2016/12/14.
 */
public class Contact extends RealmObject {
    public String name;
    public RealmList<Email> emails;
}
