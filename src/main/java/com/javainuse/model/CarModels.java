package com.javainuse.model;

import java.util.Vector;

public class CarModels {
    private Vector<String> carModelsList = new Vector<String>();
    private String selectedMark;

    public CarModels(String selectedMark) {
        this.selectedMark = selectedMark;
    }

    public String getSelectedMark() {
        return selectedMark;
    }

    public void setCarModelsList(Vector<String> carModelsList) {
        this.carModelsList = carModelsList;
    }

    public Vector<String> getCarModelsList() {
        return carModelsList;
    }

    public void addCarModel(String carModel) {
        carModelsList.add(carModel);
    }

    public void clearList() {
        carModelsList.clear();
    }
}
