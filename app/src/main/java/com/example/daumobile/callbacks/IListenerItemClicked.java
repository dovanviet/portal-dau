package com.example.daumobile.callbacks;

import com.example.daumobile.Model.authen.People;
import com.example.daumobile.Model.home.HomeItem;

public interface IListenerItemClicked {
    default void onItemClicked(int position) {}
    default void onItemClicked(HomeItem item) {}
}
