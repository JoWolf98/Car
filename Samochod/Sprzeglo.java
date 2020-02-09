package Samochod;

public class Sprzeglo extends Komponent
{
    private int stan_sprzegla;

    public void zalacz(){
        System.out.println("zalaczony");
        stan_sprzegla=1;
    }
    public void rozlacz(){
        System.out.println("rozlacz");
        stan_sprzegla=0;
    }

    public int getStan_sprzegla(){

        return this.stan_sprzegla;
    }

    public Sprzeglo(String nazwa,int waga, int cena){

        super(nazwa,waga,cena);
    }
}
