package com.javainuse.model;

public class Discount {
    private double percentage;

    public Discount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "percentage=" + percentage +
                '}';
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public double getPercentage() {
        return percentage;
    }
}
