package Samochod;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.lang.String;

public class Samochod2_GUI implements Obserwator{//gui obswerwuje silnik

    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JLabel Nazwa;
    private JTextField nazwaTextField;
    private JRadioButton załącz;
    private JRadioButton rozłącz;
    private JTabbedPane Silnik;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JRadioButton uruchomionyRadioButton;
    private JRadioButton zatrzymanyRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton zwiększButton;
    private JButton zmniejszButton;
    private JButton zwiększButton1;
    private JButton zmniejszButton1;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton Jazda;

    private static Silnik silnik=new Silnik("Dobry",45,120,8000,1000);
    private static Sprzeglo sprzeglo=new Sprzeglo("Swietne",12,1000);
    private static Skrzynia_biegow skrzynia = new Skrzynia_biegow("dobra",1200,1000,0,6,200,sprzeglo);
    private static Samochod renault=new Samochod(silnik,sprzeglo,skrzynia,"srebrny","KRA 12345","Clio","Renault",180);


    private void refresh() {
        textField10.setText(renault.getModel());
        textField11.setText(renault.getNrRejestru());
        textField9.setText(renault.getMarka());
        textField12.setText(String.valueOf(renault.aktualna_predkosc()));
        nazwaTextField.setText(sprzeglo.getNazwa());
        textField6.setText(String.valueOf(skrzynia.ilosc_biegow()));
        textField7.setText(String.valueOf(skrzynia.aktualny_bieg()));
        textField8.setText(String.valueOf(skrzynia.aktualne_przelozenie()));
        textField1.setText(String.valueOf(silnik.getNazwa()));
        textField2.setText(String.valueOf(silnik.getWaga()));
        textField3.setText(String.valueOf(silnik.getCena()));
        textField4.setText(String.valueOf(silnik.getMaxObroty()));
        textField5.setText(String.valueOf(silnik.getObroty()));

    }
    public Samochod2_GUI(Samochod renault,Skrzynia_biegow skrzynia,Sprzeglo sprzeglo,Silnik silnik) {
        silnik.subskrybuj(this);// jak chce to miec zakomentowane to w silniku inform tez musze zakomentowac tu nastepuje subskrypcja this =gui,gui subskrybuje silnik,czyli obserwuej
       uruchomionyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField10.setText(renault.getModel());
                textField11.setText(renault.getNrRejestru());
                textField9.setText(renault.getMarka());
                textField12.setText(String.valueOf(renault.aktualna_predkosc()));
                nazwaTextField.setText(sprzeglo.getNazwa());
                textField1.setText(String.valueOf(silnik.getNazwa()));
                textField2.setText(String.valueOf(silnik.getWaga()));
                textField3.setText(String.valueOf(silnik.getCena()));
                textField4.setText(String.valueOf(silnik.getMaxObroty()));
                textField5.setText(String.valueOf(silnik.getObroty()));
                textField6.setText(String.valueOf(skrzynia.ilosc_biegow()));
                textField7.setText(String.valueOf(skrzynia.aktualny_bieg()));
                textField8.setText(String.valueOf(skrzynia.aktualne_przelozenie()));
    refresh();
            }
        });


      załącz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
                sprzeglo.zalacz();
                System.out.println(sprzeglo.getStan_sprzegla());
            }
        });
        rozłącz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sprzeglo.rozlacz();
                System.out.println(sprzeglo.getStan_sprzegla());

            }
        });

        zwiększButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                silnik.zwieksz_obroty();
                renault.aktualna_predkosc2();
                refresh();
            }
        });
        zmniejszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                silnik.zmniejsz_obroty();
                renault.aktualna_predkosc2();
                refresh();
            }
        });

        zmniejszButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                skrzynia.zmniejsz_bieg();
                    renault.aktualna_predkosc2();
                }
                catch(SprzegloException wyjatek){
                    wyjatek.printStackTrace();
                }

                refresh();
            }
        });
        zwiększButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    skrzynia.zwieksz_bieg();
                } catch (SprzegloException wyjatek) {
                    wyjatek.printStackTrace();
                }
                renault.aktualna_predkosc2();
                refresh();
            }
        });

        uruchomionyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                silnik.uruchom();
                refresh();
            }
        });
        zatrzymanyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                silnik.zatrzymaj();
                skrzynia.setAktualny_bieg(0);
                skrzynia.aktualny_bieg();
                renault.setPredkosc(0);
                renault.aktualna_predkosc2();
                refresh();
            }

        });
        Jazda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int przelozenie=skrzynia.aktualne_przelozenie();
                silnik.zwieksz_obroty();
                try{
                skrzynia.zwieksz_bieg();}
                catch(SprzegloException wyjatek){
                    wyjatek.printStackTrace();
                }
                skrzynia.ObliczPrzelozenie();
                renault.aktualna_predkosc2();
                refresh();
            }
        });

       // refresh();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Samochod_GUI");
        frame.setContentPane(new Samochod2_GUI(renault,skrzynia,sprzeglo,silnik).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Thread watek = new Thread(silnik);//tworzenie watku
        silnik.uruchom();
        watek.start();// uruchomienie watku

    }

    public void inform() {
        refresh(); //nadpisanie metody z interfejsu obserwator
    }

}




