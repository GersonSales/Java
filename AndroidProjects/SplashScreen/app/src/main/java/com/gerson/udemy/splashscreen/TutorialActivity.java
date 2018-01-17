package com.gerson.udemy.splashscreen;

<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TutorialActivity extends AppCompatActivity {
=======
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.gerson.udemy.splashscreen.adapter.TutorialAdapter;

public class TutorialActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewHolder;
>>>>>>> e5ed65065d322ec54997893436bc16c7edbad6ef

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
<<<<<<< HEAD
    }
}
=======

        hideStatusBar();
        setupViewHolder();

    }

    private void setupViewHolder() {
        this.mViewHolder = new ViewHolder();

        mViewHolder.setSkipTutorialBt((Button) findViewById(R.id.skip_tutorial_bt));
        mViewHolder.getSkipTutorialBt().setOnClickListener(this);

        mViewHolder.setmTutorialViewPager((ViewPager) findViewById(R.id.tutorial_viewPager));
        mViewHolder.getmTutorialViewPager().setAdapter(new TutorialAdapter(this));
    }


    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.skip_tutorial_bt:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
//                finish();
        }
    }

    public static class ViewHolder {
        private Button mSkipTutorialBt;
        private ViewPager mTutorialViewPager;

        ViewPager getmTutorialViewPager() {
            return mTutorialViewPager;
        }

        void setmTutorialViewPager(ViewPager mTutorialViewPager) {
            this.mTutorialViewPager = mTutorialViewPager;
        }

        Button getSkipTutorialBt() {
            return mSkipTutorialBt;
        }

        void setSkipTutorialBt(Button mSkipTutorialBt) {
            this.mSkipTutorialBt = mSkipTutorialBt;
        }
    }
}
>>>>>>> e5ed65065d322ec54997893436bc16c7edbad6ef
