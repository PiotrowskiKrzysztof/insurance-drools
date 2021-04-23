package com.javainuse.gui;

import com.javainuse.model.CarMarks;
import com.javainuse.model.CarModels;
import com.javainuse.model.Contract;
import org.drools.core.StatefulSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MainFrame extends JFrame {

    private JPanel panel;
    private JButton calculateBTTN; //przycisk do obliczenia ubezpieczenia
    private JComboBox carMarkCB; // Box z wyborem marki auta
    private JComboBox carModelCB; // Box z modelem samochodu
    private JComboBox carAgeCB; // Box z wiekiem samochodu
    private JComboBox volumeEngineCB; // Box z pojemnością silnika
    private JComboBox horsePowerCB; // Box z mocą silnika
    private JComboBox driversAgeCB; // Box z wiekiem kierowcy
    private JComboBox carLicenceAgeCB; // Box z latami posiadania prawa jazdy
    private JComboBox genderCB; // Box z płcią kierowcy
    private JComboBox accidentFreeDrivingCB; // Box z pytaniem, czy kierowca mial ostatnio wypadek
    private JLabel priceLAB; // etykieta z oszacowaną cena
    private JLabel carMarkLAB;
    private JLabel carModelLAB;
    private JLabel driverAgeLAB;
    private JLabel horsePowerLAB;
    private JLabel descCarLAB;
    private JLabel descDriverLAB;
    private JLabel descDiscountLAB;

    private void init() {
        // Layout okna programu

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 500));
        setLayout(new GridLayout(6, 2));
        setTitle("Calculate OC");

        // Box z markami samochodów
        carMarkCB = new JComboBox();
        Vector<String> marks = new Vector<String>();
        marks.add("Wybierz marke");
        for(CarMarks mark : CarMarks.values()) {
            marks.add(mark.toString());
        }
        carMarkCB.setModel(new DefaultComboBoxModel(marks));

        // Box z modelami samochodu
        carModelCB = new JComboBox();
        Vector<String> cml = new Vector<String>();
//        cml.add("Wybierz model");
        carModelCB.setModel(new DefaultComboBoxModel(cml));

        // Box z rokiem produkcji samochodu
        carAgeCB = new JComboBox();
        Vector<Integer> cAge = new Vector<Integer>();
        for(int i = 2021; i > 1950; i--) {
            cAge.add(i);
        }
        carAgeCB.setModel(new DefaultComboBoxModel(cAge));

        // Box z pojemnoscią silnika
        volumeEngineCB = new JComboBox();
        Vector<Double> volEnd = new Vector<Double>();
        volEnd.add(1.4);
        volEnd.add(2.0);
        volEnd.add(3.0);
        volumeEngineCB.setModel(new DefaultComboBoxModel(volEnd));

        // Box z mocą silnika
        horsePowerCB = new JComboBox();
        Vector<Integer> hp = new Vector<Integer>();
        hp.add(80);
        hp.add(150);
        hp.add(300);
        horsePowerCB.setModel(new DefaultComboBoxModel(hp));

        // Box z wiekiem kierowcy
        driversAgeCB = new JComboBox();
        Vector<Integer> dAge = new Vector<Integer>();
        for(int i = 16; i < 100; i++) {
            dAge.add(i);
        }
        driversAgeCB.setModel(new DefaultComboBoxModel(dAge));

        // Box z latami posiadania prawa jazdy
        carLicenceAgeCB = new JComboBox();
        Vector<Integer> clAge = new Vector<Integer>();
        for(int i = 1; i < 100; i++) {
            clAge.add(i);
        }
        carLicenceAgeCB.setModel(new DefaultComboBoxModel(clAge));

        // Box z płcią kierowcy
        genderCB = new JComboBox();
        Vector<String> g = new Vector<String>();
        g.add("Kobieta");
        g.add("Mężczyzna");
        genderCB.setModel(new DefaultComboBoxModel(g));


        // etykieta z ceną
        priceLAB = new JLabel();

        // etykiety opisowe
        carMarkLAB = new JLabel("Wybierz markę samochodu:");
        carModelLAB = new JLabel("Wybierz model samochodu:");
        driverAgeLAB = new JLabel("Wybierz wiek kierowcy:");
        horsePowerLAB = new JLabel("Wybierz moc samochodu:");

        // etykiety podsumowujące
        descCarLAB = new JLabel();

        descDriverLAB = new JLabel();
        descDiscountLAB = new JLabel();

        // przycisk do wyliczenia ceny ubezpieczenia
        calculateBTTN = new JButton("Wylicz cenę!");

        // dodanie elementow do layoutu
        add(carMarkLAB);
        add(carMarkCB);
        add(carModelLAB);
        add(carModelCB);
//        add(carAgeCB);
//        add(volumeEngineCB);
        add(horsePowerLAB);
        add(horsePowerCB);
        add(driverAgeLAB);
        add(driversAgeCB);
//        add(carLicenceAgeCB);
//        add(genderCB);
        add(priceLAB);
        add(calculateBTTN);
        add(descCarLAB);
        add(descDriverLAB);
//        add(descDiscountLAB);
    }

    // konstruktor
    public MainFrame(final StatefulSession session) {
        init();
        // JComboBox z markami samochodów
        carMarkCB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();
                    if(item.toString() != "Wybierz marke") {
                        carMarkCB.removeItem("Wybierz marke");
                    }
                    Vector<String> carModelsList = new Vector<String>();
                    carModelsList.add("Wybierz model");
                    for(CarModels model : CarModels.values()) {
                        if(model.getCarMark() == item.toString()) {
                            carModelsList.add(model.toString());
                        }
                    }
//                    if(item.toString() == "BMW") {
//                        carModelsList.clear();
//                        carModelsList.add("Wybierz model");
//                        carModelsList.add("seria 3");
//                        carModelsList.add("seria 6");
//                    }
//                    if(item.toString() == "Ford") {
//                        carModelsList.clear();
//                        carModelsList.add("Wybierz model");
//                        carModelsList.add("Mondeo");
//                        carModelsList.add("Focus");
//                    }
//                    if(item.toString() == "Skoda") {
//                        carModelsList.clear();
//                        carModelsList.add("Wybierz model");
//                        carModelsList.add("Superb");
//                        carModelsList.add("Octavia");
//                    }

                    carModelCB.setModel(new DefaultComboBoxModel(carModelsList));
                }
            }
        });
        // JComboBox z modelami wybranego samochodu
        carModelCB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();
                    if(item.toString() != "Wybierz model") {
                        carModelCB.removeItem("Wybierz model");
                    }
                }
            }
        });

        // Przycisk obliczajacy wartosc ubezpieczenia
        calculateBTTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Contract contract = new Contract();

//                Driver driver = new Driver();
                contract.getDriver().setDriverAge((Integer)driversAgeCB.getSelectedItem());
//                driver.setYearsDriverLicence((Integer)driversAgeCB.getSelectedItem());
//                driver.setGender(genderCB.getSelectedItem().toString());

//                Car car = new Car();
                contract.getCar().setCarMark(carMarkCB.getSelectedItem().toString());
                contract.getCar().setCarModel(carModelCB.getSelectedItem().toString());
//                car.setCarAge((Integer)carAgeCB.getSelectedItem());
//                car.setVolumeEngine((Double)volumeEngineCB.getSelectedItem());
                contract.getCar().setHorsePower((Integer)horsePowerCB.getSelectedItem());

                session.insert(contract);
//                session.insert(driver);
//                session.insert(car);

                session.setGlobal("startPrice", 1000.0);

                session.fireAllRules();

                getPriceLAB().setText(
                        "<html>" +
                        "<b>" + "Cena ubezpieczenia: " + String.valueOf(contract.getPrice()) + "<br>" +
                        "</html>"
                );

                getDescCarLAB().setText(
                        "<html>" +
                        "Samochód marki: " + contract.getCar().getCarMark() + "<br>" +
                        "Model: " + contract.getCar().getCarModel() + "<br>" +
                        "Segment samochodu: " + contract.getCar().getCarType().toString() + "<br>" +
                        "Moc samochodu: " + contract.getCar().getHorsePower() + "km" + "<br>" +
                        "</html>"
                );

                String drivType = "";
                if(contract.getDriver().getDriverType().toString() == "EXPRIENCED") drivType = "Doświadczony kierowca";
                else if (contract.getDriver().getDriverType().toString() == "INEXPRIENCED") drivType = "Niedoświadczony kierowca";

                String disc = "";
                if(contract.getDiscount() == null) {
                    disc = "Nie uwzględniono ci żadnych zniżek";
                } else {
                    disc = "Twoja zniżka wynosi: " + contract.getDiscount().getPercentage() * 100 + "%";
                }

                getDescDriverLAB().setText(
                        "<html>" +
                            drivType + "<br>" +
                            disc +
                        "</html>"
                );

                System.out.println(contract);
//                System.out.println(car);
//                System.out.println(driver);
            }
        });
        setVisible(true);
    }

    public JComboBox getCarAgeCB() {
        return carAgeCB;
    }

    public JComboBox getVolumeEngineCB() {
        return volumeEngineCB;
    }

    public JComboBox getHorsePowerCB() {
        return horsePowerCB;
    }

    public void setCarModelCB(JComboBox carModelCB) {
        this.carModelCB = carModelCB;
    }

    public void setCarAgeCB(JComboBox carAgeCB) {
        this.carAgeCB = carAgeCB;
    }

    public void setVolumeEngineCB(JComboBox volumeEngineCB) {
        this.volumeEngineCB = volumeEngineCB;
    }

    public void setHorsePowerCB(JComboBox horsePowerCB) {
        this.horsePowerCB = horsePowerCB;
    }

    public void setDriversAgeCB(JComboBox driversAgeCB) {
        this.driversAgeCB = driversAgeCB;
    }

    public void setCarLicenceAgeCB(JComboBox carLicenceAgeCB) {
        this.carLicenceAgeCB = carLicenceAgeCB;
    }

    public JButton getCalculateBTTN() {
        return calculateBTTN;
    }

    public JComboBox getCarMarkCB() {
        return carMarkCB;
    }

    public JComboBox getCarModelCB() {
        return carModelCB;
    }

    public JComboBox getDriversAgeCB() {
        return driversAgeCB;
    }

    public JComboBox getCarLicenceAgeCB() {
        return carLicenceAgeCB;
    }

    public JLabel getPriceLAB() {
        return priceLAB;
    }

    public void setCalculateBTTN(JButton calculateBTTN) {
        this.calculateBTTN = calculateBTTN;
    }

    public void setCarMarkCB(JComboBox carMarkCB) {
        this.carMarkCB = carMarkCB;
    }

    public void setPriceLAB(JLabel priceLAB) {
        this.priceLAB = priceLAB;
    }

    public JComboBox getGenderCB() {
        return genderCB;
    }

    public JComboBox getAccidentFreeDrivingCB() {
        return accidentFreeDrivingCB;
    }

    public JLabel getCarMarkLAB() {return carMarkLAB;}

    public JLabel getDescCarLAB() {return descCarLAB;}

    public JLabel getDescDriverLAB() {return descDriverLAB;}

    public JLabel getDescDiscountLAB() {return descDiscountLAB;}
}