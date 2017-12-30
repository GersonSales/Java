package com.nokia.cap.carros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nokia.cap.carros.R;
import com.nokia.cap.carros.data.CarMock;
import com.nokia.cap.carros.entities.Car;
import com.nokia.cap.carros.viewholder.CarViewHolder;

import java.util.zip.Inflater;

/**
 * Created by GersonSales on 12/22/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private CarMock mCarMock;

    public CarListAdapter() {
        this.mCarMock = new CarMock();

    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View carView = inflater.inflate(R.layout.row_car_list, parent, false);
        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = mCarMock.getById(position);
        holder.bindData(car);
    }

    @Override
    public int getItemCount() {
        return this.mCarMock.getSize();

    }
}
