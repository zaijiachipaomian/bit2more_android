package com.example.mint.bit2more_android.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mint.bit2more_android.R;
import com.example.mint.bit2more_android.model.Goods;

import java.util.ArrayList;
import java.util.List;

//  recyclerView 的数据适配器
//
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<Goods> goods = new ArrayList<>();
    // 点击事件
    private OnItemClikListener itemClikListener;
    // 长按事件
    private OnItemLongClickListener itemLongClickListener;

    public void setItemClikListener(OnItemClikListener itemClikListener) {
        this.itemClikListener = itemClikListener;
    }

    public void setItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    public RVAdapter() {
    }

    public RVAdapter(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Goods good = this.goods.get(position);
        Glide.with(holder.iv_image).load(good.getUrl()).into(holder.iv_image);
        holder.tv_detail.setText(good.getDetail());
        holder.tv_used.setText(String.valueOf(position));
        holder.tv_price.setText(String.valueOf(position));

        if (itemClikListener != null) {
            // 设置点击事件
            holder.itemView.setOnClickListener(v -> {
                itemClikListener.onItemClick(v, position);
            });
        }

        if (itemLongClickListener != null) {

            // 设置长按事件
            holder.itemView.setOnLongClickListener((v) -> {
                itemLongClickListener.onItemLongClick(v, position);
                return true;
            });
        }

    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_image;   // 精简的图片显示
        private TextView tv_detail;  // 描述说明
        private TextView tv_used;   // 使用的次数
        private TextView tv_price;   // 价格说明

        public ViewHolder(View view) {
            super(view);

            iv_image = view.findViewById(R.id.iv_image);
            tv_detail = view.findViewById(R.id.tv_detail);
            tv_used = view.findViewById(R.id.tv_used);
            tv_price = view.findViewById(R.id.tv_price);
        }
    }

    public interface OnItemClikListener {
        public void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        public void onItemLongClick(View view, int positon);
    }


}
