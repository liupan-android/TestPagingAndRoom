package com.lp.testpagingandroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lp.testpagingandroom.R;
import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.databinding.RecycleviewItemBinding;

/**
 * @Author: liupan
 * @Date: 2020/11/19
 */
public class NewsAdapter extends ListAdapter<News, NewsAdapter.NewsViewHolder> {
    private OnItemClickListener onItemClickListener;

    public NewsAdapter(OnItemClickListener onItemClickListener){
        super(DIFF_CALLBACK);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecycleviewItemBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.recycleview_item, null, false);
        return new NewsViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = getItem(position);
        holder.mBinding.setItem(news);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
            }
        });
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private RecycleviewItemBinding mBinding;
        public NewsViewHolder(RecycleviewItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }



    private static final DiffUtil.ItemCallback<News> DIFF_CALLBACK = new DiffUtil.ItemCallback<News>() {
        @Override
        public boolean areItemsTheSame(@NonNull News oldItem, @NonNull News newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }

        @Override
        public boolean areContentsTheSame(@NonNull News oldItem, @NonNull News newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getContent().equals(newItem.getContent());
        }
    };

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
