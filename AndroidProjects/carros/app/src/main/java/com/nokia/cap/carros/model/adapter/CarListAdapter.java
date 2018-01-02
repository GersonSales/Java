package com.nokia.cap.carros.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nokia.cap.carros.R;
import com.nokia.cap.carros.model.viewholder.CarViewHolder;

/**
 * Created by gersonsales on 19/12/17.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {
    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        int row_car_list_Id = R.layout.row_car_list;
        View carView = inflater.inflate(row_car_list_Id, parent, false);


        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
