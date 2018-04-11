package com.example.administrator.glidetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    String url = "https://a.vpimg3.com/upload/merchandise/pdcvis/2017/11/29/88/ee2e5d2f-196f-49af-adb9-50cc04f0241f.jpg";
            String gif="http://p1.pstatp.com/large/166200019850062839d3";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
    }

//    public void loadImage(View view) {
//        String url = "https://a.vpimg3.com/upload/merchandise/pdcvis/2017/11/29/88/ee2e5d2f-196f-49af-adb9-50cc04f0241f.jpg";
//        String gif="http://p1.pstatp.com/large/166200019850062839d3";
//        //placeholder 占位图
//        //diskCacheStrategy(DiskCacheStrategy.NONE),禁用掉Glide的缓存功能.
//        //error,loaderror
//        //自动判断图片类型并加载（可加载gif图片）
//        //asBitmap(),只加载静态图片
//        //    .override(100, 100),固定宽高,,默认会自动判断需要加载尺寸,Target.SIZE_ORIGINAL加载原图大小.
//        //不缓存user头像
//        //glide刚准备加载一张图片，还没来得及开始呢，activity就已经被destroy了。这种情况可以改下glide的源码，对这个异常捕获，既然activity已经被destroy了，那也根本不需要加载图片，保证不崩溃就行了
//        Glide.with(this)
//                .load(gif)
//                .asBitmap()
//                .placeholder(R.mipmap.ic_launcher)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .error(R.drawable.error)
//                .override(100, 100)
//                .into(imageView);
//    }


    //获取到GlideDrawable对象
//    SimpleTarget<GlideDrawable> simpleTarget = new SimpleTarget<GlideDrawable>() {
//        @Override
//        public void onResourceReady(GlideDrawable resource, GlideAnimation glideAnimation) {
//            imageView.setImageDrawable(resource);
//        }
//    };
//
//    public void loadImage(View view) {
//        Glide.with(this)
//                .load(url)
//                .into(simpleTarget);
//    }

//      如果确定你正在加载的是一张静态图而不是GIF图的话，就能直接拿到这张图的Bitmap对象
//      获取到Bitmap对象
//    SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>() {
//        @Override
//        public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
//            imageView.setImageBitmap(resource);
//        }
//    };
//    public void loadImage(View view) {
//        Glide.with(this)
//                .load(url)
//                .asBitmap()
//                .into(simpleTarget);
//
//
//    }

    public void loadImage(View view) {
        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .preload();
//        Glide.with(this)
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .into(imageView);
    }

    public void load(View view) {
        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target,
                                               boolean isFirstResource) {
                        Toast.makeText(getApplicationContext(),"onException"+e.toString(), Toast.LENGTH_LONG).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model,
                                                   Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Toast.makeText(getApplicationContext(),"onResourceReady", Toast.LENGTH_LONG).show();
                        return false;
                    }
                })
                .into(imageView);
    }


    public void DownloadImageT(View view){
        Glide.with(this)
                .load(url)
                .downloadOnly(new DownloadImageTarget());
    }
    public void downloadImage(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    String url = "http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg";
                    final Context context = getApplicationContext();
                    FutureTarget<File> target = Glide.with(context)
                            .load(url)
                            .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
                    final File imageFile = target.get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, imageFile.getPath(), Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    }
