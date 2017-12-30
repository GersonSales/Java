package com.nokia.cap.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nokia.cap.carros.R;
import com.nokia.cap.carros.entities.Car;

import org.w3c.dom.Text;

/**
 * Created by GersonSales on 12/22/2017.
 */

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(View itemView) {
        super(itemView);
        this.mTextModel = itemView.findViewById(R.id.model_text);
    }

    public void bindData(Car car) {
        mTextModel.setText(car.getModel());
    }
}
