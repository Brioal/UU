package com.brioal.uu.entity;

/**
 * 首页轮播广告实体类
 * Created by Brioal on 2016/7/18.
 */

public class HomeAdEntity {
    private String mImageUrl; //图片地址
    private String mContentUrl; //物品地址

    public HomeAdEntity(String imageUrl, String contentUrl) {
        mImageUrl = imageUrl;
        mContentUrl = contentUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getContentUrl() {
        return mContentUrl;
    }

    public void setContentUrl(String contentUrl) {
        mContentUrl = contentUrl;
    }
}
