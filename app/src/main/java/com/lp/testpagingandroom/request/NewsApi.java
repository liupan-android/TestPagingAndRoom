package com.lp.testpagingandroom.request;

import com.lp.testpagingandroom.AppApiConst;
import com.lp.testpagingandroom.bean.CommonResult;
import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.bean.NewsResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
public interface NewsApi {

    /**
     *
     * @param channel 频道
     * @param start   数据起始位置
     * @param num     数据数量
     * @return
     */
    @FormUrlEncoded
    @POST(AppApiConst.NEWS)
    Call<CommonResult<NewsResult>> postNews(@Field("channel") String channel, @Field("start") int start, @Field("num") int num, @Field("appkey") String appkey);
}
