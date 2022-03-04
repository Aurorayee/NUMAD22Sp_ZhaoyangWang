package com.example.numad22sp_zhaoyangwang;

import android.content.Context;

import java.net.URL;

public class Item {
    private String url;
    private String name;

    public Item(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
