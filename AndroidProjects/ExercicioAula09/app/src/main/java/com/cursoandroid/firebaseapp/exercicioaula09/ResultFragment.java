package com.cursoandroid.firebaseapp.exercicioaula09;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cursoandroid.firebaseapp.exercicioaula09.constant.Constants;

import static com.cursoandroid.firebaseapp.exercicioaula09.constant.ActivityCode.CANCELED_CODE;
import static com.cursoandroid.firebaseapp.exercicioaula09.constant.ActivityCode.SUB_ACTIVITY_REQUEST_CODE;
import static com.cursoandroid.firebaseapp.exercicioaula09.constant.Constants.RESULT;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    public static final String TAG = "RESULT_FRAGMENT";
    private ViewHolder mViewHolder;


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        intent = intent == null ? new Intent() : intent;

        if (resultCode == SUB_ACTIVITY_REQUEST_CODE.code) {
            if (intent.hasExtra(RESULT)) {
                mViewHolder.OperationResult.setText(intent.getStringExtra(RESULT));
            }
        }else
            if(resultCode == CANCELED_CODE.code) {
                mViewHolder.OperationResult.setText(Constants.CANCELED);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_result, container, false);
        setupViewHolder(view);

        return view;
    }

    private void setupViewHolder(View view) {
        mViewHolder = new ViewHolder();
        mViewHolder.OperationResult = view.findViewById(R.id.operation_result);
    }


    private class ViewHolder {
        TextView OperationResult;
    }
}
