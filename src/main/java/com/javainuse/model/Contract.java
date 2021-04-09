package com.javainuse.model;

import java.util.HashSet;
import java.util.Set;

public class Contract {

    private double price;

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return "Contract{" + ", price=" + price + '}';
    }
}