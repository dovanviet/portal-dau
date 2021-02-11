package com.example.daumobile.callbacks;

import com.example.daumobile.model.home.HomeItem;

public interface IListenerItemClicked {
    default void onItemClicked(int position) {}
    default void onItemClicked(HomeItem item) {}
    default void onItemPauseClicked(int position) {}
}
