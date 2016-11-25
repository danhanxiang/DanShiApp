package com.danshi.danhanxinag.activity;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.danshi.danhanxinag.base.BaseActivity;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.utils.SystemUtil;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by 20939 on 2016/11/17.
 */
public class MeiZhiDetailActivity extends BaseActivity{
    @BindView(R.id.bitmap_image_view)
    PhotoView bitmapImageView;
    @BindView(R.id.my_toolbar)
    Toolbar bitmapToolbar;

    private String bitmapUrl;
    private String bitmapId;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_meizhi);
        ButterKnife.bind(this);
        bitmapToolbar.setTitle("Picture");
        /* 设置Toolbar上的返回按钮 */
        setSupportActionBar(bitmapToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bitmapToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bitmapId = getIntent().getExtras().getString("PicId");
        bitmapUrl = getIntent().getExtras().getString("PicUrl");
        Glide.with(this).load(bitmapUrl).error(R.drawable.logo).into(bitmapImageView);
        mProgressDialog = new ProgressDialog(this);
    }

    public void showDialog(){
        if (mProgressDialog != null){
            mProgressDialog.show();
        }
    }
    public void hideDialog(){
        if (mProgressDialog != null){
            mProgressDialog.hide();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bitmap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_save:
                savePicture(this, bitmapId);
                break;
            case R.id.action_wall:
                makeWallpaper();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 把图片设置成手机壁纸
     */
    private void makeWallpaper() {
        showDialog();
        Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                Bitmap bitmap = null;
                try {
                    bitmap = Picasso.with(MeiZhiDetailActivity.this).load(bitmapUrl).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                subscriber.onNext(bitmap);
                subscriber.onCompleted();

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {
                        hideDialog();
                        Toast.makeText(MeiZhiDetailActivity.this, "壁纸设置成功", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(Bitmap bitmap) {

                        try {
                            WallpaperManager instance = WallpaperManager.getInstance(MeiZhiDetailActivity.this);
                            int desiredMinimumWidth = getWindowManager().getDefaultDisplay().getWidth();
                            int desiredMinimumHeight = getWindowManager().getDefaultDisplay().getHeight();
                            instance.suggestDesiredDimensions(desiredMinimumWidth, desiredMinimumHeight);
                            instance.setBitmap(bitmap);

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                    }
                });
    }

    private void savePicture(final Context context, final String id) {
        showDialog();
        Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                Bitmap bitmap = null;
                try {
                    /* Picasso加载图片质量高于Glide */
                    bitmap = Picasso.with(context).load(bitmapUrl).get();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
                if (bitmap == null) {
                    subscriber.onError(new Exception("无法下载图片"));
                }
                subscriber.onNext(bitmap);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {
                    hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        SystemUtil.saveBitmapToFile(MeiZhiDetailActivity.this,id,bitmap);
//                        File appDir = new File(Environment.getExternalStorageDirectory(), "/DanShiAPP/");
//                        String pictureName = id + ".jpg";
//                        File file = new File(appDir, pictureName);
//                        try {
//                            FileOutputStream outputStream = new FileOutputStream(file);
//                            /* 断言,true则继续执行,false则java.lang.AssertionError */
//                            assert (bitmap != null);
//                            /**
//                             * 压缩图片
//                             * @param quality 压缩率  100 表示不压缩
//                             */
//                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//                            outputStream.flush();
//                            outputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        /* 通知图库更新 */
//                        Uri uri = Uri.fromFile(file);
//                        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
//                        Toast.makeText(context, "图片已保存", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
