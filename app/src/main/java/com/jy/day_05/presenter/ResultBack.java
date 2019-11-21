package com.jy.day_05.presenter;

import com.jy.day_05.bean.Bean;

import java.util.List;

public interface ResultBack {
    void onSuccess(List<Bean.T1348647909107Bean> beans);
    void onFaile(String msg);
}
