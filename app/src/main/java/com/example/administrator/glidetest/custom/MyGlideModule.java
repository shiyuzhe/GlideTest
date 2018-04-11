package com.example.administrator.glidetest.custom;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.volley.VolleyUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

/**
 * Created by Administrator on 2018/1/17.
 */

public class MyGlideModule implements GlideModule {

    public static final int DISK_CACHE_SIZE = 500 * 1024 * 1024;
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //Glide默认的硬盘缓存策略使用的是InternalCacheDiskCacheFactory，这种缓存会将所有Glide加载的图片都存储到当前应用的私有目录下,但是开发者自己也是无法查看的。
        //Glide本身就内置了一个ExternalCacheDiskCacheFactory，可以允许将加载的图片都缓存到SD卡。
        //默认硬盘缓存大小都是250M
//        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context));
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context,DISK_CACHE_SIZE));
//        Glide加载图片的默认格式是RGB_565,想要图片效果更加细腻需要使用ARGB_8888，但是会增加内存开销
//        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
//        glide.register(GlideUrl.class, InputStream.class, new OkHttpGlideUrlLoader.Factory());
        glide.register(GlideUrl.class, InputStream.class, new VolleyUrlLoader.Factory(context));
    }
}
