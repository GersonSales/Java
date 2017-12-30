package com.nokia.cap.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nokia.cap.carros.R;
import com.nokia.cap.carros.adapter.CarListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewHolder();

    }

    private void setupViewHolder() {
        ViewHolder mViewHolder = new ViewHolder();
        mViewHolder.setRecyclerCars((RecyclerView) findViewById(R.id.recycler_cars));

        CarListAdapter carListAdapter = new CarListAdapter();
        mViewHolder.getRecyclerCars().setAdapter(carListAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.getRecyclerCars().setLayoutManager(linearLayoutManager);

    }


    public static class ViewHolder {
        private RecyclerView recyclerCars;

        RecyclerView getRecyclerCars() {
            return recyclerCars;
        }

        void setRecyclerCars(RecyclerView recyclerCars) {
            this.recyclerCars = recyclerCars;
        }
    }
}
