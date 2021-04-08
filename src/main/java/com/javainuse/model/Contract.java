package com.javainuse.model;

import java.util.HashSet;
import java.util.Set;

public class Contract {

    private String carMark;
    private int driversAge;
    private int carLicenceAge;
    private int volumeEngine;
    private double price;

    public void setDriversAge(int driversAge) {
        this.driversAge = driversAge;
    }

    public void setCarLicenceAge(int carLicenceAge) {
        this.carLicenceAge = carLicenceAge;
    }

    public int getDriversAge() {
        return driversAge;
    }

    public int getCarLicenceAge() {
        return carLicenceAge;
    }

    public String getCarMark() {return carMark;}
    public int getVolumeEngine() {return volumeEngine;}
    public double getPrice() {return price;}
    public void setCarMark(String carMark) {this.carMark = carMark;}
    public void setVolumeEngine(int volumeEngine) {this.volumeEngine = volumeEngine;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return "Contract{" +
                "carMark='" + carMark + '\'' +
                ", volumeEngine=" + volumeEngine +
                ", price=" + price +
                '}';
    }
}