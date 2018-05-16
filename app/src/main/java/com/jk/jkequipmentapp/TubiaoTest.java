package com.jk.jkequipmentapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.jk.jkequipmentapp.bean.WaterLevelBean;
import com.jk.jkequipmentapp.commom.ChartUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */

public class TubiaoTest extends Activity {
     private LineChart lineChart;// 声明图表控件
    private int wendu[]={1,2,3,4,6,5,6,7,8};
    private ArrayList<WaterLevelBean> waterLevelBeens=new ArrayList<WaterLevelBean>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.tubiao_layout);
        initView();
    }

    private void initView() {
        lineChart= (LineChart) findViewById(R.id.lineChart);
        List<Entry> entrys=new ArrayList<Entry>();
        for (int i=0;i<wendu.length;i++){
            WaterLevelBean waterLevelBean=new WaterLevelBean();
            waterLevelBean.setxValue(i+"/12");
            waterLevelBean.setyValue(wendu[i]);
            waterLevelBeens.add(waterLevelBean);
        }
        for (int i=0;i<waterLevelBeens.size();i++){
            Entry entry=new Entry(i,waterLevelBeens.get(i).getyValue(),waterLevelBeens.get(i));

            entrys.add(entry);
        }

        ChartUtil.showChart(getApplicationContext(),lineChart,entrys,"水位表","--多少米","m");
    }
}
