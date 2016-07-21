package com.brioal.uu.entity;

/**逛逛界面物品分类实体类
 * Created by Brioal on 2016/7/19.
 */

public class GuangEntity {
    private String mImageUrl ;
    private String mTitle ;

    public GuangEntity(String imageUrl, String title) {
        mImageUrl = imageUrl;
        mTitle = title;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
