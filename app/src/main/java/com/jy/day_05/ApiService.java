package com.jy.day_05;

import com.jy.day_05.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String baseUrl = "http://c.m.163.com/nc/article/headline/T1348647909107/";

    @GET("0-20.html")
    Observable<Bean> getData();
}
