package com.javainuse.model;

public enum CarModels {
    Seria3("BMW", 2.4),
    Seria6("BMW", 3.0),
    Mondeo("Ford", 2.0),
    Focus("Ford", 1.5),
    Superb("Skoda", 2.2),
    Octavia("Skoda", 1.8);

    String carMark;
    double ratioModel;

    CarModels(String carMark, double ratioModel) {
        this.carMark = carMark;
        this.ratioModel = ratioModel;
    }

    public String getCarMark() {
        return carMark;
    }

    public double getRatioModel() {
        return ratioModel;
    }
}
