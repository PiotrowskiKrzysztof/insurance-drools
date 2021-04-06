package com.javainuse.gui;

import com.javainuse.model.Contract;
import org.drools.core.StatefulSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Vector;

public class MainFrame extends JFrame {

    private JButton calculate; //przycisk do obliczenia ubezpieczenia
    private JComboBox carsMark; // Box z wyborem marki auta
    private JTextField volumeEngine; // Pole tekstowe z pojemnością silnika
    private LinkedList<Character> allowedChars; // lista z dozwolonymi znakami dla pojemnosci silnika
    private JLabel price; // etykieta z oszacowaną

    private void init() {
        // Layout okna programu
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 128));
        setLayout(new GridLayout(4, 1));
        setTitle("Calculate OC");

        // Box z markami samochodów
//        String[] marksList = {"Skoda", "BMW", "Ford"};
        carsMark = new JComboBox();
        Vector<String> marks = new Vector<String>();
        marks.add("BMW");
        marks.add("Ford");
        marks.add("Skoda");
        carsMark.setModel(new DefaultComboBoxModel(marks));

        // Pole tekstowe z pojemnością silnika
        volumeEngine = new JTextField();
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
        volumeEngine.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                if(!allowedChars.contains(e.getKeyChar())) {
                    e.consume(); // Jeżeli wprowadzi sie znak spoza listy, zostanie on usuniety
                }
            }
        });

        // etykieta z ceną
        price = new JLabel();

        // przycisk do wyliczenia ceny ubezpieczenia
        calculate = new JButton("Wylicz cenę!");

        // dodanie elementow do layoutu
        add(carsMark);
        add(volumeEngine);
        add(price);
        add(calculate);
    }

    // konstruktor
    public MainFrame(final StatefulSession session) {
        init();
        getCalculate().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Contract contract = new Contract();
                contract.setCarMark(getCarsMark().getSelectedItem().toString());
                contract.setVolumeEngine(Integer.parseInt(getVolumeEngine().getText().trim()));
                session.insert(contract);
//                session.setGlobal("bBMW", 1000);
//                session.setGlobal("bFord", 800);
//                session.setGlobal("bSkoda", 600);
                session.fireAllRules();
                System.out.println(contract);
            }
        });
        setVisible(true);
    }

    public JButton getCalculate() {return calculate;}
    public void setCalculate(JButton calculate) {this.calculate = calculate;}
    public JLabel getPrice() {return price;}
    public void setPrice(JLabel price) {this.price = price;}
    public LinkedList<Character> getAllowedChars() {return allowedChars;}
    public void setAllowedChars(LinkedList<Character> allowedChars) {this.allowedChars = allowedChars;}
    public JTextField getVolumeEngine() {return volumeEngine;}
    public void setVolumeEngine(JTextField volumeEngine) {this.volumeEngine = volumeEngine;}
    public JComboBox getCarsMark() {return carsMark;}
    public void setCarsMark(JComboBox carsMark) {this.carsMark = carsMark;}
}
