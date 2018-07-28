package com.pratik.mvvmrecyclerview.model;

public class News
{public String title,desc;

    public News(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
