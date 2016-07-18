package com.brioal.uu.entity;

/**
 * 首页内容big实体类
 * Created by Brioal on 2016/7/18.
 */

public class HomeItemBigEntity {
    private String mImageUrlLeft ; //左边图片地址
    private String mContentUrLeft ; //左边物品地址
    private String mImageUrlRT; //右上图片地址
    private String mContentRT ; //右上物品地址

    private String mImageRBL ; //底部左边图片地址
    private String mContentRBL ; //地址左边内容地址

    private String mImageRBR ; //底部右边图片地址
    private String mContentRBR ; //底部右边物品地址

    public HomeItemBigEntity(String imageUrlLeft, String contentUrLeft, String imageUrlRT, String contentRT, String imageRBL, String contentRBL, String imageRBR, String contentRBR) {
        mImageUrlLeft = imageUrlLeft;
        mContentUrLeft = contentUrLeft;
        mImageUrlRT = imageUrlRT;
        mContentRT = contentRT;
        mImageRBL = imageRBL;
        mContentRBL = contentRBL;
        mImageRBR = imageRBR;
        mContentRBR = contentRBR;
    }

    public String getImageUrlLeft() {
        return mImageUrlLeft;
    }

    public void setImageUrlLeft(String imageUrlLeft) {
        mImageUrlLeft = imageUrlLeft;
    }

    public String getContentUrLeft() {
        return mContentUrLeft;
    }

    public void setContentUrLeft(String contentUrLeft) {
        mContentUrLeft = contentUrLeft;
    }

    public String getImageUrlRT() {
        return mImageUrlRT;
    }

    public void setImageUrlRT(String imageUrlRT) {
        mImageUrlRT = imageUrlRT;
    }

    public String getContentRT() {
        return mContentRT;
    }

    public void setContentRT(String contentRT) {
        mContentRT = contentRT;
    }

    public String getImageRBL() {
        return mImageRBL;
    }

    public void setImageRBL(String imageRBL) {
        mImageRBL = imageRBL;
    }

    public String getContentRBL() {
        return mContentRBL;
    }

    public void setContentRBL(String contentRBL) {
        mContentRBL = contentRBL;
    }

    public String getImageRBR() {
        return mImageRBR;
    }

    public void setImageRBR(String imageRBR) {
        mImageRBR = imageRBR;
    }

    public String getContentRBR() {
        return mContentRBR;
    }

    public void setContentRBR(String contentRBR) {
        mContentRBR = contentRBR;
    }
}
