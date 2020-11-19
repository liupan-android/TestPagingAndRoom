/**
 * 练习使用Jetpack
 * 采用MVVM架构
 * databinding + ViewModel + livedata
 * 网络                :  Retrofit
 * 数据库              :  Room
 * 分页                :  Paging
 * Fragment跳转        :  Navigation
 *
 */

package com.lp.testpagingandroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}