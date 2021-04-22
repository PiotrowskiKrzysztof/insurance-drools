package com.javainuse.model;

import java.util.HashSet;
import java.util.Set;

public class Contract {

    private double price;
    private Discount discount;
    private Driver driver;
    private Car car;

    public Contract() {
        this.driver = new Driver();
        this.car = new Car();
    }

    public Driver getDriver() {
        return driver;
    }

    public Car getCar() {
        return car;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "price=" + price +
                ", discount=" + discount +
                ", driver=" + driver +
                ", car=" + car +
                '}';
    }

    public void log(String tmp){
        System.out.println(tmp);
    }
}