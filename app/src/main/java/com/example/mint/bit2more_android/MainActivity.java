package com.example.mint.bit2more_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.mint.bit2more_android.model.Goods;
import com.example.mint.bit2more_android.util.RVAdapter;

import java.util.ArrayList;
import java.util.List;

// android 练习手册
public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<Goods> goods = new ArrayList<>();

    private void initGoogs() {
        for (int i = 0; i < 100; i++) {
            Goods g = new Goods();

            g.setDetail("detail    " + i);
            g.setOuted(false);
            g.setName("ok ");
            g.setPrice(4.5);
            g.setUsedTime(45);
            g.setUrl(String.valueOf("https://github.com/bumptech/glide/raw/master/static/glide_logo.png"));

            goods.add(g);
        }

        for (int i = 99; i < 200; i++) {
            Goods g = new Goods();
            g.setDetail("info  http://cn.bing.com/az/hprichbg/rb/HamersleyGorge_ZH-CN6901064951_1920x1080.jpg " + i);
            g.setOuted(false);
            g.setName("ok ");
            g.setPrice(4.5);
            g.setUsedTime(45);
            g.setUrl(String.valueOf("http://cn.bing.com/az/hprichbg/rb/HamersleyGorge_ZH-CN6901064951_1920x1080.jpg"));

            goods.add(g);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);

        initGoogs();

        RVAdapter rvAdapter = new RVAdapter(goods);

        // 实现 ItemClikListener 接口
        rvAdapter.setItemClikListener((view, pos) -> {

            Toast.makeText(this, "click event  " + String.valueOf(pos), Toast.LENGTH_SHORT).show();
        });
        // 实现ItemLongClickListener 接口
        rvAdapter.setItemLongClickListener((view, pos) -> {
            Toast.makeText(this, "long click  event  " + String.valueOf(pos), Toast.LENGTH_SHORT).show();


        });
        // 设置数据适配器
        rv.setAdapter(rvAdapter);
        // 设置布局
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }
}
