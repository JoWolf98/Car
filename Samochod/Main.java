package Samochod;

public class Main {

    public static void main(String[] args) {
        Samochod samochod = new Samochod(new Silnik("jakis", 60,1000, 3000,800),new Sprzeglo("jakies",90,3000),new Skrzynia_biegow("dobra",60,4000,1,6,3444,new Sprzeglo("jakies",90,3000)),"biale","KRA234560","Clio","Renault",180);
        samochod.oblicz_wage();

    }
}