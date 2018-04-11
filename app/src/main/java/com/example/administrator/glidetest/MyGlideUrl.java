package com.example.administrator.glidetest;

import com.bumptech.glide.load.model.GlideUrl;

/**
 * Created by Administrator on 2018/1/15.
 * in order to delete token from some Pictures of cloud server
 * 为了删除某些云服务器（七牛）中为url添加的token值
 * exchange token will not be the unique identification
 * 变换的token将导致图片url不能成为唯一标识
 * how to use
 * Glide.with(this).load(new MyGlideUrl(url)).into(imageView);
 */
public class MyGlideUrl extends GlideUrl {

    private String mUrl;

    public MyGlideUrl(String url) {
        super(url);
        mUrl = url;
    }

    @Override
    public String getCacheKey() {
        return mUrl.replace(findTokenParam(), "");
    }

    private String findTokenParam() {
        String tokenParam = "";
        int tokenKeyIndex = mUrl.indexOf("?token=") >= 0 ? mUrl.indexOf("?token=") : mUrl.indexOf("&token=");
        if (tokenKeyIndex != -1) {
            int nextAndIndex = mUrl.indexOf("&", tokenKeyIndex + 1);
            if (nextAndIndex != -1) {
                tokenParam = mUrl.substring(tokenKeyIndex + 1, nextAndIndex + 1);
            } else {
                tokenParam = mUrl.substring(tokenKeyIndex);
            }
        }
        return tokenParam;
    }

}