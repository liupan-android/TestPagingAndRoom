package com.lp.testpagingandroom.viewmodel;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lp.testpagingandroom.NetworkUtil;
import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.db.AbstractRoomDatabase;
import com.lp.testpagingandroom.db.RoomDatabaseImpl;
import com.lp.testpagingandroom.executor.AppExecutor;
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
        if (NetworkUtil.isNetworkConnected()) {
            NewsRequest.getAllNews(0, 20, new RequestCallback() {
                @Override
                public void onSuccess(List<News> list) {
                    isLoading.set(false);
                    newsLiveData.postValue(list);
                    AppExecutor.getInstance().execute(new Runnable() {
                        @Override
                        public void run() {
                            RoomDatabaseImpl.getInstance().newsDao().addNews(list);
                        }
                    });
                }

                @Override
                public void onError(String error) {
                    isLoading.set(false);
                }
            });
        } else {
            AppExecutor.getInstance().execute(new Runnable() {
                @Override
                public void run() {
                    List<News> list = RoomDatabaseImpl.getInstance().newsDao().getAllNews();
                    if(list != null && list.size() > 0){
                        isLoading.set(false);
                        newsLiveData.postValue(list);
                    }
                }
            });
        }
    }


    public interface RequestCallback{
        void onSuccess(List<News> list);
        void onError(String error);
    }
}
