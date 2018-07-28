package com.pratik.mvvmrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pratik.mvvmrecyclerview.adapter.CustomAdapter;
import com.pratik.mvvmrecyclerview.model.News;
import com.pratik.mvvmrecyclerview.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    List<NewsViewModel> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsList = new ArrayList<>();

        customAdapter = new CustomAdapter(MainActivity.this,newsList);
        recyclerView.setAdapter(customAdapter);

        setData();
    }

    private void setData() {
        NewsViewModel news1 = new NewsViewModel(new News("Title1","This is news one"));
        newsList.add(news1);
        NewsViewModel news2 = new NewsViewModel(new News("Title2","This is news two"));
        newsList.add(news2);
        NewsViewModel news3 = new NewsViewModel(new News("Title3","This is news three"));
        newsList.add(news3);
        NewsViewModel news4 = new NewsViewModel(new News("Title4","This is news Four"));
        newsList.add(news4);
    }
}
