package com.lp.testpagingandroom.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.request.NewsRequest;

import java.util.List;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
public class NewsViewModel extends ViewModel {
    private MutableLiveData<List<News>> newsLiveData = new MutableLiveData<>();
    private ObservableBoolean isLoading = new ObservableBoolean(false);

    public MutableLiveData<List<News>> getNewsLiveData() {
        return newsLiveData;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void loadData(){
        isLoading.set(true);
        NewsRequest.getAllNews(0, 20, new RequestCallback() {
            @Override
            public void onSuccess(List<News> list) {
                isLoading.set(false);
                newsLiveData.postValue(list);
            }

            @Override
            public void onError(String error) {
                isLoading.set(false);
            }
        });
    }


    public interface RequestCallback{
        void onSuccess(List<News> list);
        void onError(String error);
    }
}
