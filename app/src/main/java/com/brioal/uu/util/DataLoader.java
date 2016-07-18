package com.brioal.uu.util;

import android.content.Context;

import com.brioal.brioallib.interfaces.OnLoadCompleteListener;
import com.brioal.uu.entity.HomeAdEntity;
import com.brioal.uu.entity.HomeContentEntity;
import com.brioal.uu.entity.HomeItemBigEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brioal on 2016/7/18.
 */

public class DataLoader {
    private static DataLoader mLoader;
    private Context mContext;

    public static DataLoader newInstance(Context context) {
        if (mLoader == null) {
            mLoader = new DataLoader(context);
        }
        return mLoader;
    }

    public DataLoader(Context context) {
        mContext = context;
    }

    //获取首页的Banner数据
    public void getHomeList(OnLoadCompleteListener listener) {
        List<HomeAdEntity> list = new ArrayList<>();
        list.add(new HomeAdEntity("http://192.168.191.1/UUTest/ic_image_test_01.jpg", ""));
        list.add(new HomeAdEntity("http://192.168.191.1/UUTest/ic_image_test_02.jpg", ""));
        list.add(new HomeAdEntity("http://192.168.191.1/UUTest/ic_image_test_03.jpg", ""));
        list.add(new HomeAdEntity("http://192.168.191.1/UUTest/ic_image_test_04.jpg", ""));
        listener.onSuccess(list);
    }

    //获取首页大的的内容
    public void getHomeBigContent(OnLoadCompleteListener listener) {
        HomeItemBigEntity entity = new HomeItemBigEntity(
                "http://192.168.191.1/UUTest/ic_image_test_01.jpg",
                "",
                "http://192.168.191.1/UUTest/ic_image_test_02.jpg",
                "",
                "http://192.168.191.1/UUTest/ic_image_test_03.jpg",
                "",
                "http://192.168.191.1/UUTest/ic_image_test_04.jpg",
                ""
        );
        List list = new ArrayList();
        list.add(entity);
        listener.onSuccess(list);
    }

    //获取首页物品列表
    public void getHomeContents(OnLoadCompleteListener listener) {
        List<HomeContentEntity> list = new ArrayList<>();
        list.add(new HomeContentEntity("http://192.168.191.1/UUTest/ic_image_test_01.jpg", "", "名称名称名称名称名称名称", 19.9f, 200, 10));
        list.add(new HomeContentEntity("http://192.168.191.1/UUTest/ic_image_test_02.jpg", "", "名称名称名称名称名称名称", 19.9f, 200, 10));
        list.add(new HomeContentEntity("http://192.168.191.1/UUTest/ic_image_test_03.jpg", "", "名称名称名称名称名称名称", 19.9f, 200, 10));
        list.add(new HomeContentEntity("http://192.168.191.1/UUTest/ic_image_test_04.jpg", "", "名称名称名称名称名称名称", 19.9f, 200, 10));
        list.add(new HomeContentEntity("http://192.168.191.1/UUTest/ic_image_test_03.jpg", "", "名称名称名称名称名称名称", 19.9f, 700, 110));
        list.add(new HomeContentEntity("http://192.168.191.1/UUTest/ic_image_test_04.jpg", "", "名称名称名称名称名称名称", 19.9f, 200, 110));
        listener.onSuccess(list);
    }
}
