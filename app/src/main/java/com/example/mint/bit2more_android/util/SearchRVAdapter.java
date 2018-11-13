package com.example.mint.bit2more_android.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.mint.bit2more_android.R;

public class SearchRVAdapter extends RecyclerView.Adapter<SearchRVAdapter.ViewHolder> {

    private List<String> list = new ArrayList<String>();
    private OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public SearchRVAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_rv_item, null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String info = list.get(position);
        holder.search_tv.setText(String.valueOf(info));

        if (itemClickListener != null) {
            holder.search_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 调用点击事件
                    itemClickListener.onItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView search_tv;

        public ViewHolder(View view) {
            super(view);

            search_tv = view.findViewById(R.id.search_item_tv);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
}
