package com.javainuse.gui;

import com.javainuse.model.CarMarks;
import com.javainuse.model.CarModels;
import com.javainuse.model.Contract;
import org.drools.core.StatefulSession;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MainFrame extends JFrame {

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel footerPanel;
    private JButton calculateBTTN; //przycisk do obliczenia ubezpieczenia
    private JComboBox carMarkCB; // Box z wyborem marki auta
    private JComboBox carModelCB; // Box z modelem samochodu
    private JComboBox carAgeCB; // Box z wiekiem samochodu
    private JComboBox horsePowerCB; // Box z mocą silnika
    private JComboBox driversAgeCB; // Box z wiekiem kierowcy
    private JLabel priceLAB; // etykieta z oszacowaną cena
    private JLabel carMarkLAB;
    private JLabel carModelLAB;
    private JLabel driverAgeLAB;
    private JLabel horsePowerLAB;
    private JLabel descCarLAB;
    private JLabel descDriverLAB;
    private JLabel descDiscountLAB;

    Color GRAY_BLUE = new Color(139, 154, 169);

    private void init() {
        // Layout okna programu
        this.mainFrame = new JFrame("Kalkulator OC");
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setSize(new Dimension(600,720));
        this.mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.northPanel = new JPanel();
        TitledBorder titled = BorderFactory.createTitledBorder("Określanie profilu kierowcy oraz auta");
//        titled.setTitleColor(GRAY_BLUE);
//        titled.setBorder();
        Border northPanelBorder = titled;
        Border northPanelMargin = new EmptyBorder(10, 10, 10, 10);
        this.northPanel.setBorder(new CompoundBorder(northPanelBorder, northPanelMargin));
        this.northPanel.setPreferredSize(new Dimension(600, 250));
        this.northPanel.setLayout(new GridLayout(4, 2));

        this.centerPanel = new JPanel();
        this.centerPanel.setLayout(new BorderLayout());

        this.footerPanel = new JPanel();
        this.footerPanel.setLayout(new BorderLayout());



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

        // etykieta z ceną
        priceLAB = new JLabel();

        // etykiety opisowe
        carMarkLAB = new JLabel("Marka samochodu:");
        carModelLAB = new JLabel("Model samochodu:");
        driverAgeLAB = new JLabel("Wiek kierowcy:");
        horsePowerLAB = new JLabel("Moc samochodu:");

        // etykiety podsumowujące
        descCarLAB = new JLabel();

        descDriverLAB = new JLabel();
        descDiscountLAB = new JLabel();

        // przycisk do wyliczenia ceny ubezpieczenia
        calculateBTTN = new JButton("Wylicz cenę!");

        // dodanie elementow do layoutu
        this.mainFrame.add(this.mainPanel, BorderLayout.CENTER);
        this.mainPanel.add(this.northPanel, BorderLayout.NORTH);
        this.mainPanel.add(this.centerPanel, BorderLayout.CENTER);
        this.northPanel.add(carMarkLAB);
        this.northPanel.add(carMarkCB);
        this.northPanel.add(carModelLAB);
        this.northPanel.add(carModelCB);
        this.northPanel.add(horsePowerLAB);
        this.northPanel.add(horsePowerCB);
        this.northPanel.add(driverAgeLAB);
        this.northPanel.add(driversAgeCB);
        this.mainFrame.add(footerPanel, BorderLayout.SOUTH);
        this.footerPanel.add(calculateBTTN, BorderLayout.NORTH);
        this.footerPanel.add(new JLabel("Projekt na zaliczenie przedmiotu Systemy ekspertowe", SwingConstants.CENTER), BorderLayout.CENTER);
        this.footerPanel.add(new JLabel("Wykonawcy: Krzysztof Piotrowski oraz Daniel Sadłowski", SwingConstants.CENTER), BorderLayout.SOUTH);
        calculateBTTN.setPreferredSize(new Dimension(600, 50));

        Border marginLAB = new EmptyBorder(10, 10, 10, 10);
        this.centerPanel.add(priceLAB, BorderLayout.NORTH);
        Border priceLABBorder = BorderFactory.createTitledBorder("Dane ubezpieczenia");
        priceLAB.setBorder(new CompoundBorder(priceLABBorder, marginLAB));
        priceLAB.setPreferredSize(new Dimension(600, 110));
        priceLAB.setFont(new Font(priceLAB.getFont().toString(), Font.BOLD, 22));
        this.centerPanel.add(descCarLAB, BorderLayout.CENTER);
        Border descCarLABBorder = BorderFactory.createTitledBorder("Dane pojazdu");
        descCarLAB.setBorder(new CompoundBorder(descCarLABBorder, marginLAB));
        descCarLAB.setPreferredSize(new Dimension(600, 110));
        this.centerPanel.add(descDriverLAB, BorderLayout.SOUTH);
        Border descDriverLABBorder = BorderFactory.createTitledBorder("Dane kierowcy");
        descDriverLAB.setBorder(new CompoundBorder(descDriverLABBorder, marginLAB));
        descDriverLAB.setPreferredSize(new Dimension(600, 110));

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
        mainFrame.setVisible(true);
    }

    public JComboBox getCarAgeCB() {
        return carAgeCB;
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

    public void setHorsePowerCB(JComboBox horsePowerCB) {
        this.horsePowerCB = horsePowerCB;
    }

    public void setDriversAgeCB(JComboBox driversAgeCB) {
        this.driversAgeCB = driversAgeCB;
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

    public JLabel getCarMarkLAB() {return carMarkLAB;}

    public JLabel getDescCarLAB() {return descCarLAB;}

    public JLabel getDescDriverLAB() {return descDriverLAB;}

    public JLabel getDescDiscountLAB() {return descDiscountLAB;}
}