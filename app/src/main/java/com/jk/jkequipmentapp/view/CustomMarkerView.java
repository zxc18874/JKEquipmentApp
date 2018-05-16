package com.jk.jkequipmentapp.view;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.jk.jkequipmentapp.R;
import com.jk.jkequipmentapp.bean.EntryBaseBean;

/**
 * Created by Administrator on 2018/2/26.
 */

public class CustomMarkerView extends MarkerView{
    private TextView tvContent;
    private String unitName;
    /**
     *
     * @param context
     *            上下文
     * @param layoutResource
     *            资源文件
     * @param unitName
     *            Y轴数值计量单位名称
     */
    public CustomMarkerView(Context context, int layoutResource, final String unitName) {
        super(context, layoutResource);
        // 显示布局中的文本框
        tvContent = (TextView) findViewById(R.id.txt_tips);
        this.unitName = unitName;
    }

    // 每次markerview回调重绘，可以用来更新内容
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        // 设置Y周数据源对象Entry的value值为显示的文本内容
        tvContent.setText("" + ((EntryBaseBean)e.getData()).getyValue()+unitName);
    }


    public int getXOffset(float xpos) {
        // 水平居中
        return -(getWidth() / 2);
    }


    public int getYOffset(float ypos) {
        // 提示框在坐标点上方显示
        return -getHeight();
    }
}
