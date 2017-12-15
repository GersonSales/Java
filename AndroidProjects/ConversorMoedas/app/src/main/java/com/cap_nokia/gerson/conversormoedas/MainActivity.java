package com.cap_nokia.gerson.conversormoedas;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViewHolder();






    }

    private void setUpViewHolder() {
        this.mViewHolder.setmCalcButton((Button) findViewById(R.id.calc_button));
        this.mViewHolder.setmDollarText((TextView) findViewById(R.id.dollar_text));
        this.mViewHolder.setmEuroText((TextView) findViewById(R.id.euro_text));
        this.mViewHolder.setmEditValue((EditText) findViewById(R.id.edit_value));

        setUpOnClickListener();
    }

    private void setUpOnClickListener() {
        this.mViewHolder.getmCalcButton().setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.calc_button:
                Double realVelue = Double.valueOf(this.mViewHolder.getmEditValue().getText().toString());
                String dollarValue = String.format("$%.2f", realVelue * 3.52);
                String euroValue = String.format("$%.2f", realVelue * 4.23);
                this.mViewHolder.getmDollarText().setText(dollarValue);
                this.mViewHolder.getmEuroText().setText(euroValue);


                this.mViewHolder.getmCalcButton().setText("Calculado!");
        }
    }


    private static class ViewHolder {
        private EditText mEditValue;
        private TextView mDollarText;
        private TextView mEuroText;
        private Button mCalcButton;


        public EditText getmEditValue() {
            return mEditValue;
        }

        public void setmEditValue(EditText mEditValue) {
            this.mEditValue = mEditValue;
        }

        public TextView getmDollarText() {
            return mDollarText;
        }

        public void setmDollarText(TextView mDollarText) {
            this.mDollarText = mDollarText;
        }

        public TextView getmEuroText() {
            return mEuroText;
        }

        public void setmEuroText(TextView mEuroText) {
            this.mEuroText = mEuroText;
        }

        public Button getmCalcButton() {
            return mCalcButton;
        }

        public void setmCalcButton(Button mCalcButton) {
            this.mCalcButton = mCalcButton;
        }
    }




}
