package com.lp.testpagingandroom;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.testpagingandroom.adapter.NewsAdapter;
import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.databinding.FragmentMainBinding;
import com.lp.testpagingandroom.viewmodel.NewsViewModel;

import java.util.List;

public class MainFragment extends Fragment {
    private NewsViewModel mNewsViewModel;
    private NewsAdapter mAdapter;
    private FragmentMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        mAdapter = new NewsAdapter(onItemClickListener);
        binding.recycleView.setAdapter(mAdapter);
        initObserver();
        return binding.getRoot();
    }

    private void initObserver(){
        mNewsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        mNewsViewModel.getNewsLiveData().observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {
                mAdapter.submitList(news);
            }
        });
        mNewsViewModel.loadData();
        binding.setNewsViewModel(mNewsViewModel);
    }

    NewsAdapter.OnItemClickListener onItemClickListener = new NewsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            News news = mAdapter.getCurrentList().get(position);
            Bundle bundle = new Bundle();
            bundle.putString("content", news.getContent());
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_descriptionFragment, bundle);
        }
    };

}