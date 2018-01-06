package com.cursoandroid.firebaseapp.exercicioaula09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.cursoandroid.firebaseapp.exercicioaula09.ActivityCode.SUB_ACTIVITY_REQUEST_CODE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewHolder();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SUB_ACTIVITY_REQUEST_CODE.getCode()) {
            mViewHolder.mHelloMainActivity.setText(R.string.hello_subActivity);
        }
    }

    private void setupViewHolder() {
        mViewHolder = new ViewHolder();
        mViewHolder.mHelloMainActivity = findViewById(R.id.hello_mainActivity);
        mViewHolder.mButton = findViewById(R.id.mainActivity_button);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.mainActivity_button:
                Intent intent = new Intent(this, SubActivity.class);
                startActivityForResult(intent, SUB_ACTIVITY_REQUEST_CODE.getCode());
                Log.i("Intent", "SubActivity intent started");
                break;

        }
    }

    private class ViewHolder {
        TextView mHelloMainActivity;
        Button mButton;
    }


}
