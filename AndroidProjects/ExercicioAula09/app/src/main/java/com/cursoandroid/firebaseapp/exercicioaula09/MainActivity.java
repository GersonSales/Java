package com.cursoandroid.firebaseapp.exercicioaula09;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.cursoandroid.firebaseapp.exercicioaula09.constant.ActivityCode.SUB_ACTIVITY_REQUEST_CODE;
import static com.cursoandroid.firebaseapp.exercicioaula09.constant.Constants.RESULT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewHolder();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        mViewHolder.resultFragment.onActivityResult(requestCode,resultCode, intent);
    }

    private void setupViewHolder() {
        setupFragment();

        mViewHolder = new ViewHolder();
        mViewHolder.sumButton = findViewById(R.id.mainActivity_button);


        mViewHolder.sumButton.setOnClickListener(this);

        mViewHolder.resultFragment = fragmentManager.findFragmentByTag(ResultFragment.TAG);
    }

    private void setupFragment() {
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.result_frameLayout, new ResultFragment(), ResultFragment.TAG);

        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.mainActivity_button:
                Intent intent = new Intent(this, SubActivity.class);
                startActivityForResult(intent, SUB_ACTIVITY_REQUEST_CODE.code);
                break;
        }
    }

    private class ViewHolder {
        Button sumButton;
        Fragment resultFragment;
    }


}
