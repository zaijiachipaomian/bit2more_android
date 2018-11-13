package com.example.mint.bit2more_android.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

// recycler view 中子项的间隔
// 这里可以对子项做任何操作
public class RecyclerViewSpaceItemDecoration extends RecyclerView.ItemDecoration {
    // 子项间隔的上方
    public static String TOP_DECORATION = "top_decoration";
    // 子项之间的下方
    public static String BOTTOM_DECORATION = "bottom_decoration";
    // 子项之间的左边
    public static String LEFT_DECORATION = "left_decoration";
    // 子项之间的右边
    public static String RIGHT_DECORATION = "right_decoration";


    private Map<String, Integer> mSpaceValueMap = new HashMap<String, Integer>();

    // 初始化
    public RecyclerViewSpaceItemDecoration(Map<String, Integer> mSpaceValueMap) {
        this.mSpaceValueMap = mSpaceValueMap;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // 设置各个子项之间的上方的位置
        // 默认为空
        if (mSpaceValueMap.get(TOP_DECORATION) != null) {
            outRect.top = mSpaceValueMap.get(TOP_DECORATION);
        }

        // 设置子项的左边间距
        // 默认为空
        if (mSpaceValueMap.get(LEFT_DECORATION) != null) {
            outRect.left = mSpaceValueMap.get(LEFT_DECORATION);
        }

        // 设置子项的 右边间距
        // 默认为空
        if (mSpaceValueMap.get(RIGHT_DECORATION) != null) {
            outRect.right = mSpaceValueMap.get(RIGHT_DECORATION);
        }

        // 设置子项的 下边间距
        // 默认为空
        if (mSpaceValueMap.get(BOTTOM_DECORATION) != null) {
            outRect.bottom = mSpaceValueMap.get(BOTTOM_DECORATION);
        }

    }
}
