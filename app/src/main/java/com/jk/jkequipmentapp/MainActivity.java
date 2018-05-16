package com.jk.jkequipmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private static final int one = 0X0001;
    private int progress;
    private WaveProgressView waveProgressView;
    private Button setprogress_btn;
    private Button setprogress_btn1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress++;
            switch (msg.what) {
                case one:
                    if (progress <= 77) {

                        waveProgressView.setCurrent(progress, progress + "%");
                        sendEmptyMessageDelayed(one, 100);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }
    private void Init() {
        setprogress_btn= (Button) findViewById(R.id.setprogress_btn);
        setprogress_btn1= (Button) findViewById(R.id.setprogress_btn1);
        waveProgressView=(WaveProgressView)findViewById(R.id.waveProgressbar);
        setprogress_btn.setOnClickListener(this);
        setprogress_btn1.setOnClickListener(this);
        waveProgressView.allowProgressInBothDirections(true);
       // waveProgressView.setCurrent(77, "788M/1024M");
       /* waveProgressbar2.setCurrent(77, "788M/1024M");
        waveProgressbar2.setWaveColor("#5b9ef4");
        waveProgressbar2.setText("#FFFF00", 41);

        waveProgressbar3.setWaveColor("#f0b55e");
        waveProgressbar4.setWaveColor("#61f25e");*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setprogress_btn:
                setTotalProgress(70);
                break;
            case R.id.setprogress_btn1:
            //    waveProgressView.setCurrent(40, "40%");
                  startActivity(new Intent(MainActivity.this,MachineListActivity.class));
                break;
            default:
                break ;
        }
    }
    private void setTotalProgress(int total){
        progress=0;


        handler.sendEmptyMessageDelayed(one, 1000);
    }

    /*public void onClick() {
        handler.sendEmptyMessageDelayed(one, 1000);
    }*/
}

