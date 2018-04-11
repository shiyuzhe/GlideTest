package com.example.administrator.glidetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {
    String url = "https://a.vpimg3.com/upload/merchandise/pdcvis/2017/11/29/88/ee2e5d2f-196f-49af-adb9-50cc04f0241f.jpg";
    MyLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myLayout = (MyLayout) findViewById(R.id.backround);
    }

    public void loadImage(View view) {
        Glide.with(this)
                .load(url)
                .into(myLayout.getTarget());
    }
}
