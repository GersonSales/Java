package com.nokia.cap.carros.data;

import com.nokia.cap.carros.entities.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GersonSales on 12/22/2017.
 */

public class CarMock {

    private List<Car> mCarList;

    public CarMock() {
        this.mCarList = new ArrayList<>();
        populateCarList();
    }

    private void populateCarList() {
        for(int i = 0; i < 100; i++) {
          Car newCar = new Car(String.valueOf(i), i * 100, i * 3.2);
          this.mCarList.add(newCar);
        }
    }

    public Car getById(int id) {
        return mCarList.get(id);
    }

    public int getSize() {
        return mCarList.size();
    }
}
