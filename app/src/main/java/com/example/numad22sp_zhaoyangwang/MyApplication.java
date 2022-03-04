package com.example.numad22sp_zhaoyangwang;

import android.app.Application;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<Item> itemList = new ArrayList<>();

    public MyApplication() throws MalformedURLException {
        // fillItemList method is for test purpose.
        // fillItemList();
    }

    public static List<Item> getItemList() {
        return itemList;
    }

    public static void setItemList(List<Item> itemList) {
        MyApplication.itemList = itemList;
    }

    public void fillItemList() throws MalformedURLException {
        Item item1 = new Item( "youtube.com", "youtube");
        Item item2 = new Item("https://leetcode.com/problemset/all/", "Leetcode");
        Item item3 = new Item("abc", "def");
        itemList.addAll(Arrays.asList(new Item[]{item1, item2, item3}));
    }
}
