package com.nokia.cap.carros.model.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nokia.cap.carros.R;

/**
 * Created by gersonsales on 19/12/17.
 */

public class CarViewHolder extends RecyclerView.ViewHolder{
    private TextView mTextModel;

    public CarViewHolder(View itemView) {
        super(itemView);

        mTextModel = itemView.findViewById(R.id.car_list_model);
    }
}
