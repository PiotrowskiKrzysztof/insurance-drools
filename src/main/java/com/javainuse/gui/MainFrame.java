package com.javainuse.gui;

import com.javainuse.model.CarModels;
import com.javainuse.model.Contract;
import org.drools.core.StatefulSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Vector;

public class MainFrame extends JFrame {

    private JButton calculateBTTN; //przycisk do obliczenia ubezpieczenia
    private JComboBox carsMarkCB; // Box z wyborem marki auta
    private JComboBox carModelCB; // Box z modelem samochodu
    private JComboBox driversAgeCB; // Box z wiekiem kierowcy
    private JComboBox carLicenceAgeCB; // Box z latami posiadania prawa jazdy
    private JTextField volumeEngineTF; // Pole tekstowe z pojemnością silnika
    private LinkedList<Character> allowedChars; // lista z dozwolonymi znakami dla pojemnosci silnika
    private JLabel priceLAB; // etykieta z oszacowaną

    private void init() {
        // Layout okna programu
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 300));
        setLayout(new GridLayout(4, 1));
        setTitle("Calculate OC");

        // Box z markami samochodów
        carsMarkCB = new JComboBox();
        Vector<String> marks = new Vector<String>();
        marks.add("Wybierz marke");
        marks.add("BMW");
        marks.add("Ford");
        marks.add("Skoda");
        carsMarkCB.setModel(new DefaultComboBoxModel(marks));

        // Box z modelami samochodu
        carModelCB = new JComboBox();
        Vector<String> cml = new Vector<String>();
        cml.add("Wybierz model");
        carModelCB.setModel(new DefaultComboBoxModel(cml));

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

        // Pole tekstowe z pojemnością silnika
        volumeEngineTF = new JTextField();
        allowedChars = new LinkedList<Character>(); // lista z cyframi (pole ma przyjmowac tylko te znaki)
        allowedChars.add('1');
        allowedChars.add('2');
        allowedChars.add('3');
        allowedChars.add('4');
        allowedChars.add('5');
        allowedChars.add('6');
        allowedChars.add('7');
        allowedChars.add('8');
        allowedChars.add('9');
        allowedChars.add('0');
        volumeEngineTF.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                if(!allowedChars.contains(e.getKeyChar())) {
                    e.consume(); // Jeżeli wprowadzi sie znak spoza listy, zostanie on usuniety
                }
            }
        });
        //

        // etykieta z ceną
        priceLAB = new JLabel();

        // przycisk do wyliczenia ceny ubezpieczenia
        calculateBTTN = new JButton("Wylicz cenę!");

        // dodanie elementow do layoutu
        add(carsMarkCB);
        add(carModelCB);
        add(driversAgeCB);
        add(carLicenceAgeCB);
        add(volumeEngineTF);
        add(priceLAB);
        add(calculateBTTN);
    }

    // konstruktor
    public MainFrame(final StatefulSession session) {
        init();
        // JComboBox z markami samochodów
        carsMarkCB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();
                    if(item.toString() != "Wybierz marke") {
                        carsMarkCB.removeItem("Wybierz marke");
                    }
                    CarModels carModels = new CarModels(item.toString());
                    session.insert(carModels);
                    session.fireAllRules();
                    carModelCB.setModel(new DefaultComboBoxModel(carModels.getCarModelsList()));
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
                contract.setCarMark(getCarsMarkCB().getSelectedItem().toString());
                contract.setDriversAge(Integer.parseInt(driversAgeCB.getSelectedItem().toString()));
                contract.setCarLicenceAge(Integer.parseInt(carLicenceAgeCB.getSelectedItem().toString()));
                contract.setVolumeEngine(Integer.parseInt(getVolumeEngineTF().getText().trim()));

                session.insert(contract);
//                session.setGlobal("bBMW", 1000);
//                session.setGlobal("bFord", 800);
//                session.setGlobal("bSkoda", 600);
                session.fireAllRules();
                getPriceLAB().setText("Cena ubezpieczenia: " + String.valueOf(contract.getPrice()));
                System.out.println(contract);
            }
        });
        setVisible(true);
    }

    public JButton getCalculateBTTN() {return calculateBTTN;}
    public void setCalculateBTTN(JButton calculateBTTN) {this.calculateBTTN = calculateBTTN;}
    public JLabel getPriceLAB() {return priceLAB;}
    public void setPriceLAB(JLabel priceLAB) {this.priceLAB = priceLAB;}
    public LinkedList<Character> getAllowedChars() {return allowedChars;}
    public void setAllowedChars(LinkedList<Character> allowedChars) {this.allowedChars = allowedChars;}
    public JTextField getVolumeEngineTF() {return volumeEngineTF;}
    public void setVolumeEngineTF(JTextField volumeEngineTF) {this.volumeEngineTF = volumeEngineTF;}
    public JComboBox getCarsMarkCB() {return carsMarkCB;}
    public void setCarsMarkCB(JComboBox carsMarkCB) {this.carsMarkCB = carsMarkCB;}
    public JComboBox getCarModelCB() {return carModelCB;}
    public JComboBox getDriversAgeCB() {return driversAgeCB;}
    public JComboBox getCarLicenceAgeCB() {return carLicenceAgeCB;}
}