package com.nokia.cap.festafimdeano.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.nokia.cap.festafimdeano.R;
import com.nokia.cap.festafimdeano.constants.FimDeAnoConstants;
import com.nokia.cap.festafimdeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder;
    private SecurityPreferences mSecurityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setupViewHolder();
        setupSecurityPreferences();

        loadDataFromActivity();
        
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(FimDeAnoConstants.PRESENCE_KEY);

            switch (presence) {
                case FimDeAnoConstants.NO_VALUE:
                    mViewHolder.getmCheckBox().setChecked(false);
                    break;

                case FimDeAnoConstants.WILL_GO:
                    mViewHolder.getmCheckBox().setChecked(true);
                    break;

                case FimDeAnoConstants.WONT_GO:
                    mViewHolder.getmCheckBox().setChecked(false);
                    break;
            }
        }
    }

    private void setupSecurityPreferences() {
        this.mSecurityPreferences = new SecurityPreferences(this);
    }

    private void setupViewHolder() {
        this.mViewHolder = new ViewHolder();


        mViewHolder.setmCheckBox((CheckBox) findViewById(R.id.participate_checkbox));
        mViewHolder.getmCheckBox().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.participate_checkbox:
                if (mViewHolder.getmCheckBox().isChecked()) {
                    mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.WILL_GO);
                }else {
                    mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.WONT_GO);
                }
                break;

        }


    }


    public static class ViewHolder {
        public CheckBox getmCheckBox() {
            return mCheckBox;
        }

        public void setmCheckBox(CheckBox mCheckBox) {
            this.mCheckBox = mCheckBox;
        }

        private CheckBox mCheckBox;
    }
}
