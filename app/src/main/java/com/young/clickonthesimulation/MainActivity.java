package com.young.clickonthesimulation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.young.clickonthesimulation.util.ClickOnTheSimulationUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //模拟滑动  300 300 起始点X、Y轴坐标 900 1000 终点X、Y轴坐标 2000时间
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "模拟滑动", Toast.LENGTH_SHORT).show();
                ClickOnTheSimulationUtil.executeCmd("input swipe 300 300 900 1000 2000");
            }
        }, 0);
        //模拟点击  300 300 X、Y轴坐标mHandler.postDelayed(new Runnable() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "模拟点击", Toast.LENGTH_SHORT).show();
                ClickOnTheSimulationUtil.executeCmd("input tap 300 300");
            }
        }, 5000);
        //模拟输入
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "模拟输入", Toast.LENGTH_SHORT).show();
                ClickOnTheSimulationUtil.executeCmd("input text abcd");
            }
        }, 6000);

    }
}
