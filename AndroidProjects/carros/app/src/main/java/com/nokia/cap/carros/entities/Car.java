package com.nokia.cap.carros.entities;

/**
 * Created by GersonSales on 12/22/2017.
 */

public class Car {
    private static int static_id=10;
    private int id;
    private String model;
    private int horsePower;
    private double price;


    public Car(String model, int horsePower, double price) {
        static_id ++;
        this.id = static_id;
        this.model = model;
        this.horsePower = horsePower;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", price=" + price +
                '}';
    }
}
