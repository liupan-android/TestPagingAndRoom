package com.lp.testpagingandroom.adapter;

import android.graphics.Rect;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lp.testpagingandroom.R;

/**
 * @Author: liupan
 * @Date: 2020/11/19
 */
public class BindingAdapter {

    @androidx.databinding.BindingAdapter("imageUrl")
    public static void setImageUrlWithGlide(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.placeholder).centerCrop().into(imageView);
    }

    @androidx.databinding.BindingAdapter("gone")
    public static void gone(View view, boolean isGone){
        if(isGone){
            view.setVisibility(View.GONE);
        }else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @androidx.databinding.BindingAdapter("itemDecoration")
    public static void setItemDecoration(RecyclerView recyclerView, int divider){
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 0,0,divider);
            }
        });
    }

    @androidx.databinding.BindingAdapter("scrollable")
    public static void setTextViewScroll(TextView textView, boolean canScroll){
        if(canScroll){
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
    }
}
