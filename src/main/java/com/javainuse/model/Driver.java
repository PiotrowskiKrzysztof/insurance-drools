package com.javainuse.model;

public class Driver {
    private int driverAge;
//    private int yearsDriverLicence;
//    private String gender;

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

//    public void setYearsDriverLicence(int yearsDriverLicence) {
//        this.yearsDriverLicence = yearsDriverLicence;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public int getDriverAge() {
        return driverAge;
    }

//    public int getYearsDriverLicence() {
//        return yearsDriverLicence;
//    }
//
//    public String getGender() {
//        return gender;
//    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverAge='" + driverAge + '\'' +
//                ", yearsDriverLicence='" + yearsDriverLicence + '\'' +
//                ", gender='" + gender + '\'' +
                '}';
    }
}
