package com.nokia.cap.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nokia.cap.mylibrary.HelloWorld;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloWorld helloWorld = new HelloWorld();

        helloWorld.sayHi();



    }
}
