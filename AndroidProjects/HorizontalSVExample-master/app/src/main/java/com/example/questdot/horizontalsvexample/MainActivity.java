package com.example.questdot.horizontalsvexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData()
    {
        mImgIds = new int[] { R.drawable.screenshot, R.drawable.screenshot, R.drawable.screenshot,R.drawable.screenshot
                 };
    }

    private void initView()
    {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++)
        {

            View view = mInflater.inflate(R.layout.activity_index_gallery_item,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText("info "+i);
            mGallery.addView(view);
        }
    }


}
