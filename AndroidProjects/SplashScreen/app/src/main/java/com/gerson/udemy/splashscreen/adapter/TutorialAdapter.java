package com.gerson.udemy.splashscreen.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gerson.udemy.splashscreen.R;
import com.gerson.udemy.splashscreen.TutorialActivity;

/**
 * Created by gersonsales on 02/01/18.
 */

public class TutorialAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImagesIDs;

    public TutorialAdapter(Context context) {
        this.mImagesIDs = new int[]{R.drawable.tip_1, R.drawable.tip_2, R.drawable.tip_3, R.drawable.tip_4};
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mImagesIDs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object).getParent();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);


        RelativeLayout.LayoutParams layoutParams;
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        relativeLayout.setLayoutParams(layoutParams);
        container.addView(relativeLayout);

        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(this.mImagesIDs[position]);
        relativeLayout.addView(imageView);

        Log.i("Script", "Build: Tip: " + (position + 1));

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)((ImageView)object).getParent());
        Log.i("Script", "Destroy: Tip: "+(position + 1));

    }




}
