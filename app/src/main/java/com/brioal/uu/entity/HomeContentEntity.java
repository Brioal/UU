package com.brioal.uu.entity;

/**首页物品实体类
 * Created by Brioal on 2016/7/18.
 */

public class HomeContentEntity {
    private String mImageUrl;//图片地址
    private String mContentUrl; //物品地址
    private String mName; //物品名称
    private float mPrice; //价格
    private int mCold; //返的金币
    private int mLikeNums; //喜欢的数量

    public HomeContentEntity(String imageUrl, String contentUrl, String name, float price, int cold, int likeNums) {
        mImageUrl = imageUrl;
        mContentUrl = contentUrl;
        mName = name;
        mPrice = price;
        mCold = cold;
        mLikeNums = likeNums;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getPrice() {
        return mPrice;
    }

    public void setPrice(float price) {
        mPrice = price;
    }

    public int getCold() {
        return mCold;
    }

    public void setCold(int cold) {
        mCold = cold;
    }

    public int getLikeNums() {
        return mLikeNums;
    }

    public void setLikeNums(int likeNums) {
        mLikeNums = likeNums;
    }
}
