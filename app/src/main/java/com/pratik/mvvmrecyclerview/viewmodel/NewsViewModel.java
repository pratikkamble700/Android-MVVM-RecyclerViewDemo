package com.pratik.mvvmrecyclerview.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;

import com.pratik.mvvmrecyclerview.model.News;

public class NewsViewModel extends BaseObservable{

    public String title,desc;

    public NewsViewModel(News news) {
        this.title = news.title;
        this.desc = news.desc;
    }
}
