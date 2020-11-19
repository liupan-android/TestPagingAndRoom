package com.lp.testpagingandroom.request;

import com.lp.testpagingandroom.AppApiConst;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
public class NewsRequest {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppApiConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
