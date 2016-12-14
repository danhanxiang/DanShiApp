package com.danshi.danhanxiang.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.danshi.danhanxiang.RealmObject.Dog;
import com.danshi.danhanxiang.base.BaseActivity;
import com.danshi.danhanxiang.danshiapp.R;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by 20939 on 2016/12/14.
 */
public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_fragment_layout);
        initView();
    }

    private void initView() {
        //增
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        final Dog dog = realm.createObject(Dog.class);
        dog.setName("tom");
        realm.commitTransaction();
        //删
        final RealmResults<Dog> dogRealmQuery = realm.where(Dog.class).equalTo("name", "tom").findAll();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog1 = dogRealmQuery.get(3);
                dog1.deleteFromRealm();
            }
        });
        //  改
        Dog id = realm.where(Dog.class).equalTo("id", 1).findFirst();
        realm.beginTransaction();
        id.setName("ids");
        realm.commitTransaction();
        //


    }
        //查
    public Dog queryDogById(String id) {
        Realm  mRealm=Realm.getDefaultInstance();

        Dog dog = mRealm.where(Dog.class).equalTo("id", id).findFirst();
        return dog;
    }
}
