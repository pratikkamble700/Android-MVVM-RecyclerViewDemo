package com.pratik.mvvmrecyclerview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pratik.mvvmrecyclerview.BR;
import com.pratik.mvvmrecyclerview.R;
import com.pratik.mvvmrecyclerview.presenter.NewsPresenterClick;
import com.pratik.mvvmrecyclerview.viewmodel.NewsViewModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    List<NewsViewModel> newsList;
    private static Context mCtx;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context mCtx,List<NewsViewModel> newsList) {
        this.newsList = newsList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) layoutInflater = LayoutInflater.from(parent.getContext());

        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.news_item_layout, parent, false);

        return new CustomViewHolder(viewDataBinding);
//        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout,parent,false);
//        return new CustomViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        NewsViewModel newsViewModel = newsList.get(position);
        holder.bind(newsViewModel);

//        News news = newsList.get(position);
//        holder.titleval.setText(news.getTitle());
//        holder.descval.setText(news.getDesc());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        public ViewDataBinding newsBinding;
//        TextView titleval,descval;

        public CustomViewHolder(ViewDataBinding newsBinding) {
            super(newsBinding.getRoot());
            this.newsBinding = newsBinding;

//            titleval = (TextView) itemView.findViewById(R.id.titleval);
//            descval = (TextView) itemView.findViewById(R.id.descval);
        }

        public void bind(final NewsViewModel viewModel){
            this.newsBinding.setVariable(BR.newsViewModel,viewModel);
            this.newsBinding.setVariable(BR.NewsPresenterClick, new NewsPresenterClick() {
                @Override
                public void OnClickedNews() {
                    Toast.makeText(mCtx.getApplicationContext(),viewModel.title,Toast.LENGTH_LONG).show();
                }
            });
        }

        public ViewDataBinding getNewsBinding() {
            return newsBinding;
        }
    }
}
