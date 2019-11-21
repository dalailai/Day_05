package com.jy.day_05.presenter;

import com.jy.day_05.MainActivity;
import com.jy.day_05.bean.Bean;
import com.jy.day_05.model.Model;
import com.jy.day_05.view.MainView;

import java.util.List;

public class Presenter {
    private final Model model;
    private MainView mainView;

    public Presenter(MainView mainView) {
        this.mainView = mainView;
        model = new Model();
    }

    public void getData() {

        model.getData(new ResultBack() {
            @Override
            public void onSuccess(List<Bean.T1348647909107Bean> beans) {
                mainView.setResultData(beans);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
