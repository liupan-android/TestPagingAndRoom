package com.lp.testpagingandroom.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lp.testpagingandroom.bean.News;

import java.util.List;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
public class NewsModelView extends ViewModel {
    private MutableLiveData<List<News>> newsLiveData = null;

    public MutableLiveData<List<News>> getNewsLiveData() {
        if(newsLiveData == null){
            newsLiveData = new MutableLiveData<>();
        }
        return newsLiveData;
    }
}
