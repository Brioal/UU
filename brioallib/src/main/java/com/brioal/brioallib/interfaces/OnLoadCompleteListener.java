package com.brioal.brioallib.interfaces;


import java.util.List;

/**
 * Created by Brioal on 2016/7/18.
 */

public interface OnLoadCompleteListener {
    void onSuccess(List list);

    void onFailed(String message);

}
