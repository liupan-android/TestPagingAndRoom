package com.lp.testpagingandroom.request;

import androidx.lifecycle.MutableLiveData;

import com.lp.testpagingandroom.AppApiConst;
import com.lp.testpagingandroom.bean.CommonResult;
import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.bean.NewsResult;
import com.lp.testpagingandroom.viewmodel.NewsViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
public class NewsRequest {
    private static final String CHANNEL = "头条";
    private static final String APPKEY = "4f122886e6ce7c11";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppApiConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getAllNews(int start, int num, NewsViewModel.RequestCallback requestCallback){
        NewsApi newsApi = retrofit.create(NewsApi.class);
        Call<CommonResult<NewsResult>> call = newsApi.postNews(CHANNEL, start, num, APPKEY);
        call.enqueue(new Callback<CommonResult<NewsResult>>() {
            @Override
            public void onResponse(Call<CommonResult<NewsResult>> call, Response<CommonResult<NewsResult>> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    requestCallback.onSuccess(response.body().data.list);
                }else {
                    requestCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<CommonResult<NewsResult>> call, Throwable t) {
                requestCallback.onError(t.getMessage());
            }
        });
    }
}
