package com.cursoandroid.firebaseapp.exercicioaula09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.cursoandroid.firebaseapp.exercicioaula09.constant.ActivityCode.CANCELED_CODE;
import static com.cursoandroid.firebaseapp.exercicioaula09.constant.ActivityCode.SUB_ACTIVITY_REQUEST_CODE;
import static com.cursoandroid.firebaseapp.exercicioaula09.constant.Constants.RESULT;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        setupViewHolder();

    }

    private void setupViewHolder() {
        mViewHolder = new ViewHolder();

        mViewHolder.mFirstValue = findViewById(R.id.first_value);
        mViewHolder.mSecondValue = findViewById(R.id.second_value);
        mViewHolder.mSumValues = findViewById(R.id.sumValues_button);
        mViewHolder.mCancel = findViewById(R.id.cancel_button);

        mViewHolder.mSumValues.setOnClickListener(this);
        mViewHolder.mCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(this, MainActivity.class);

        switch (id) {

            case R.id.sumValues_button:
                Bundle bundle = new Bundle();
                bundle.putString(RESULT, String.valueOf(getSum()));

                intent.putExtras(bundle);

                setResult(SUB_ACTIVITY_REQUEST_CODE.code, intent);
                finish();
                break;

            case R.id.cancel_button:
                setResult(CANCELED_CODE.code, intent);
                finish();
                break;
            default:
                break;
        }

    }

    private int getSum() {
        int firstValue = Integer.parseInt(String.valueOf(mViewHolder.mFirstValue.getText()));
        int secondValue = Integer.parseInt(String.valueOf(mViewHolder.mSecondValue.getText()));

        return sumValues(firstValue, secondValue);
    }

    private int sumValues(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    private class ViewHolder {
        EditText mFirstValue;
        EditText mSecondValue;

        Button mSumValues;
        Button mCancel;
    }

}
