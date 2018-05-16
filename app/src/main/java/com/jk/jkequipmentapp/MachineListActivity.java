package com.jk.jkequipmentapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jk.jkequipmentapp.adapter.MachineListAdapter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class MachineListActivity extends Activity implements  MachineListAdapter.OnItemClickListener{
   private SpringView springView;
    private RecyclerView recyclerView;
    private List<String> machine_list;
    private MachineListAdapter machine_list_adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_activity);
        initView();
        initEvent();
        initData();
    }

    private void initData() {
        machine_list=new ArrayList<String>();
        for (int i=0;i<10;i++){
            machine_list.add(i+"号设备");
        }
        // 设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        machine_list_adapter=new MachineListAdapter(this,machine_list);
        recyclerView.setAdapter(machine_list_adapter);
        machine_list_adapter.setOnItemClickListener(this);
    }

    private void initEvent() {
        springView.setEnableFooter(false);
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        machine_list.add("设备");
                        machine_list_adapter.notifyDataSetChanged();
                        springView.onFinishFreshAndLoad();//停止刷新
                    }
                },3000);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        springView.onFinishFreshAndLoad();//停止刷新
                    }
                },3000);
            }
        });
    }

    private void initView() {
        springView= (SpringView) findViewById(R.id.springView);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
       springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));
      //  springView.setHeader(new AcFunHeader(this,R.drawable.ic_launcher));
      //  springView.setFooter(new AcFunFooter(this,R.drawable.ic_launcher));
      //  springView.setHeader(new MeituanHeader(this));
       //    springView.setFooter(new MeituanFooter(this));
    }


    @Override
    public void onItemClick(View view, int Position) {
        Toast.makeText(MachineListActivity.this,Position+"点击",Toast.LENGTH_SHORT).show();
    }
}
