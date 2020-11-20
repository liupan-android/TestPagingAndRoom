package com.lp.testpagingandroom.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @Author: liupan
 * @Date: 2020/11/20
 */
public class CommonResult<T> {
    @SerializedName("status")
    public int status;
    @SerializedName("msg")
    public String msg;
    @SerializedName("result")
    public T data;
}
