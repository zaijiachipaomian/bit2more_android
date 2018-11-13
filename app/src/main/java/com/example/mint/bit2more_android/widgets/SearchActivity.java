package com.example.mint.bit2more_android.widgets;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mint.bit2more_android.R;
import com.example.mint.bit2more_android.util.RecyclerViewSpaceItemDecoration;
import com.example.mint.bit2more_android.util.SearchRVAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView search_rv;
    private List<String> list = new ArrayList<String>();
    private Map<String, Integer> directionValue = new HashMap<>();
    private EditText search_et;

    private void initList() {
        list.add(String.valueOf("more haste , less speed !"));
        list.add(String.valueOf("go go go "));
        list.add(String.valueOf("哥,你玩的是恐龙快打么?"));
        list.add(String.valueOf("好像,这个家伙很坏,比如说......."));
    }

    private void initDirectionValue() {

        directionValue.put(RecyclerViewSpaceItemDecoration.TOP_DECORATION, 16);
        directionValue.put(RecyclerViewSpaceItemDecoration.BOTTOM_DECORATION, 16);
        directionValue.put(RecyclerViewSpaceItemDecoration.LEFT_DECORATION, 16);
        directionValue.put(RecyclerViewSpaceItemDecoration.RIGHT_DECORATION, 16);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        search_et = findViewById(R.id.search_et);

        // 监听 et 的 按键事件
       search_et.setOnKeyListener(new View.OnKeyListener() {
           @Override
           public boolean onKey(View v, int keyCode, KeyEvent event) {

               // 如果keyCode == enter
               // 执行某项可用的操作
               if (keyCode == KeyEvent.KEYCODE_ENTER ){
                   EditText et = (EditText) v;
                   Toast.makeText(getApplicationContext(),et.getText(),Toast.LENGTH_SHORT ).show();
                   return true;
               }
               return false;
           }
       });

       // 实现 右边图标的点击事件...
        search_et.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // et.getCompoundDrawables()left, top, right, and bottom borders.
                Drawable drawable = search_et.getCompoundDrawables()[2];
                //如果右边没有图片，不再处理
                if (drawable == null)
                    return false;
                //如果不是按下事件，不再处理
                if (event.getAction() != MotionEvent.ACTION_UP)
                    return false;
                if (event.getX() > search_et.getWidth()
                        - search_et.getPaddingRight()
                        - drawable.getIntrinsicWidth()){

                    Toast.makeText(getApplicationContext()," 点击事件 " +search_et.getText() ,Toast.LENGTH_SHORT).show();
                 search_et.setText("");
                 // todo

                }
                return false;

            }
        });


        search_rv = findViewById(R.id.search_rv);
        initList();

        SearchRVAdapter searchRVAdapter = new SearchRVAdapter(list);
        searchRVAdapter.setItemClickListener(new SearchRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TextView tv = view.findViewById(R.id.search_item_tv);
                String str = "";
                if (tv != null) {
                    str = tv.getText().toString().trim();
                }
              //  Toast.makeText(getApplicationContext(), String.valueOf("click " + position + " tv : " + str), Toast.LENGTH_SHORT).show();
                // 设置
                search_et.setText(str);
                // todo
                // 这个使用应该使用搜索功能搜索了
            }
        });

        // 初始化分割线...
        initDirectionValue();
        // 设置分割线....
        search_rv.addItemDecoration(new RecyclerViewSpaceItemDecoration(directionValue));

        search_rv.setAdapter(searchRVAdapter);
        search_rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));



    }
}
