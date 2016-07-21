package com.brioal.uu.entity;

/**商店详情实体类
 * Created by Brioal on 2016/7/19.
 */

public class ShopDetailEntity {
    private String mShopImage;
    private float mBack;
    private String mShopUrl ;

    public ShopDetailEntity(String shopImage, float back, String shopUrl) {
        mShopImage = shopImage;
        mBack = back;
        mShopUrl = shopUrl;
    }

    public String getShopImage() {
        return mShopImage;
    }

    public void setShopImage(String shopImage) {
        mShopImage = shopImage;
    }

    public float getBack() {
        return mBack;
    }

    public void setBack(float back) {
        mBack = back;
    }

    public String getShopUrl() {
        return mShopUrl;
    }

    public void setShopUrl(String shopUrl) {
        mShopUrl = shopUrl;
    }
}
