package com.example.daumobile.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseActivity<B extends ViewBinding> extends AppCompatActivity {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected B binding;

    protected abstract B getBinding();
    protected abstract void onViewReady(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding = getBinding();
        setContentView(binding.getRoot());

        onViewReady(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
