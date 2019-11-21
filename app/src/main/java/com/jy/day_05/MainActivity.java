package com.jy.day_05;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.jy.day_05.adapter.RecAdapter;
import com.jy.day_05.bean.Bean;
import com.jy.day_05.presenter.Presenter;
import com.jy.day_05.view.MainView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.operate)
    Button mOperate;
    @BindView(R.id.delete)
    Button mDelete;
    @BindView(R.id.complete)
    Button mComplete;

    private List<Bean.T1348647909107Bean> beans;
    private RecAdapter adapter;
    private Presenter presenter;
    private List<Bean.T1348647909107Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        initView();
        initData();
    }

    private void initData() {
        presenter.getData();
    }

    private void initView() {
        mRec.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecAdapter(this, beans = new ArrayList<>());
        mRec.setAdapter(adapter);

    }

    @OnClick({R.id.rec, R.id.operate, R.id.delete, R.id.complete})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rec:
                break;
            case R.id.operate:
                boolean toggel = adapter.getToggel();
                if (toggel) {
                    adapter.setToggel(false);
                } else {
                    adapter.setToggel(true);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.delete:
                List<Bean.T1348647909107Bean> index = adapter.getIndex();
                if (index != null && index.size() > 0) {
                   beans.removeAll(index);
                }
                adapter.setToggel(false);
                adapter.setIndex();
                adapter.notifyDataSetChanged();
                break;
            case R.id.complete:
                beans.clear();
                adapter.setIndex();
                adapter.setToggel(false);
                beans.addAll(data);
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void setResultData(List<Bean.T1348647909107Bean> beans) {
        this.beans.addAll(beans);
        this.data.addAll(beans);
        adapter.notifyDataSetChanged();
    }
}
