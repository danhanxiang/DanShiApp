package com.danshi.danhanxiang.RealmObject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by 20939 on 2016/12/14.
 */
public class Dog extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private int age;

}
