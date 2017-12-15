package com.nokia.cap.festafimdeano.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nokia.cap.festafimdeano.R;
import com.nokia.cap.festafimdeano.constants.FimDeAnoConstants;
import com.nokia.cap.festafimdeano.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder;
    private SecurityPreferences mSecurityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewHolder();
        setupSecurityPreferences();

    }


    @Override
    protected void onResume() {
        super.onResume();
        verifyPresence();
    }

    private void verifyPresence() {
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE_KEY);

        switch (presence) {
            case FimDeAnoConstants.NO_VALUE:
                this.mViewHolder.getMConfirm().setText(R.string.nao_confirmado);

                break;

            case FimDeAnoConstants.WILL_GO:
                this.mViewHolder.getMConfirm().setText(R.string.confirmado_sim);
                break;

            case FimDeAnoConstants.WONT_GO:
                this.mViewHolder.getMConfirm().setText(R.string.confirmado_nao);
                break;

        }
    }

    private void setupSecurityPreferences() {
        this.mSecurityPreferences = new SecurityPreferences(this);
    }

    private void setupViewHolder() {
        this.mViewHolder = new ViewHolder();

        mViewHolder.setMRemainingDaysText((TextView) findViewById(R.id.remaining_days_text));
        mViewHolder.setMRemainingDays((TextView) findViewById(R.id.remaining_days));
        mViewHolder.setMConfirm((Button) findViewById(R.id.confirm_button));

        mViewHolder.getMConfirm().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.confirm_button:
                Intent intent = new Intent(this, DetailsActivity.class);
                String storedString = mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE_KEY);
                intent.putExtra(FimDeAnoConstants.PRESENCE_KEY, storedString);
                startActivity(intent);
                break;
        }
    }


    public static class ViewHolder {
        private TextView mRemainingDaysText;
        private TextView mRemainingDays;
        private Button mConfirm;

        public TextView getmRemainingDaysText() {
            return mRemainingDaysText;
        }

        void setMRemainingDaysText(TextView mRemainingDaysText) {
            this.mRemainingDaysText = mRemainingDaysText;
        }

        public TextView getmRemainingDays() {
            return mRemainingDays;
        }

        void setMRemainingDays(TextView mRemainingDays) {
            this.mRemainingDays = mRemainingDays;
        }

        Button getMConfirm() {
            return mConfirm;
        }

        void setMConfirm(Button mConfirm) {
            this.mConfirm = mConfirm;
        }
    }



}
