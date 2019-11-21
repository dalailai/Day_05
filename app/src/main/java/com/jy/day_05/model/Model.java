package com.jy.day_05.model;

import android.util.Log;

import com.jy.day_05.ApiService;
import com.jy.day_05.bean.Bean;
import com.jy.day_05.presenter.ResultBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    public void getData(ResultBack back) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        build.create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        if (bean != null) {
                            back.onSuccess(bean.getT1348647909107());

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("errrrrrrr", throwable.toString());
                    }
                });

    }
}
