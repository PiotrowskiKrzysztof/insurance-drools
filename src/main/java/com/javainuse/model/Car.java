package com.javainuse.model;

public class Car {
    private String carMark;
    private String carModel;
//    private int carAge;
//    private double volumeEngine;
    private int horsePower;

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

//    public void setCarAge(int carAge) {
//        this.carAge = carAge;
//    }
//
//    public void setVolumeEngine(double volumeEngine) {
//        this.volumeEngine = volumeEngine;
//    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getCarMark() {
        return carMark;
    }

    public String getCarModel() {
        return carModel;
    }

//    public int getCarAge() {
//        return carAge;
//    }
//
//    public double getVolumeEngine() {
//        return volumeEngine;
//    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carMark='" + carMark + '\'' +
                ", carModel='" + carModel + '\'' +
//                ", carAge=" + carAge +
//                ", volumeEngine=" + volumeEngine +
                ", horsePower=" + horsePower +
                '}';
    }
}
