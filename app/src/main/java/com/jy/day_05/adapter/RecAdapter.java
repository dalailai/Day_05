package com.jy.day_05.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.day_05.R;
import com.jy.day_05.bean.Bean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecAdapter extends RecyclerView.Adapter {

    private final Context context;
    private final List<Bean.T1348647909107Bean> beans;
    List<Bean.T1348647909107Bean> index = new ArrayList<>();
    boolean toogle = false;

    public RecAdapter(Context context, List<Bean.T1348647909107Bean> beans) {

        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        if (toogle) {
            holder1.mItemCheck.setVisibility(View.VISIBLE);
        } else {
            holder1.mItemCheck.setVisibility(View.GONE);
        }
        holder1.mItemCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.i("position", position + "");
                    index.add(beans.get(position));
                } else {
                    if (index.contains(beans.get(position))) {
                        index.remove(beans.get(position));
                    }
                }
            }
        });
        holder1.mItemTv.setText(beans.get(position).getTitle());
        Glide.with(context).load(beans.get(position).getImgsrc()).into(holder1.mItemImg);

    }
    public void setIndex(){
        index.clear();
    }
    public List<Bean.T1348647909107Bean> getIndex() {
        return index;
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public void setToggel(boolean b) {
        toogle = b;
    }

    public boolean getToggel() {
        return toogle;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView mItemImg;
        @BindView(R.id.item_tv)
        TextView mItemTv;
        @BindView(R.id.item_check)
        CheckBox mItemCheck;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
