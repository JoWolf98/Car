package Samochod;

public class Skrzynia_biegow extends Komponent {
    private int aktualny_bieg;
    private int ilosc_biegow;
    private int aktualne_przelozenie;
    public Sprzeglo sprzeglo;
    private Silnik silnik1;

    public Skrzynia_biegow(String nazwa, int waga, float cena, int aktualny_bieg, int ilosc_biegow, int aktualne_przelozenie, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualny_bieg = aktualny_bieg;
        this.ilosc_biegow = ilosc_biegow;
        this.aktualne_przelozenie = aktualne_przelozenie;
        this.sprzeglo = sprzeglo;
    }


    public void zwieksz_bieg() throws SprzegloException{

        if (sprzeglo.getStan_sprzegla() == 1) {
            if (aktualny_bieg < ilosc_biegow) {
                aktualny_bieg = aktualny_bieg + 1;
                System.out.println(aktualny_bieg);
            }
        } else
            throw new SprzegloException();
    }

    public int ilosc_biegow()
    {
        return this.ilosc_biegow;
    }

    public void zmniejsz_bieg()throws SprzegloException {
        if(sprzeglo.getStan_sprzegla()==1){
        if(aktualny_bieg>0){
        aktualny_bieg--;
        System.out.println(aktualny_bieg);}
        else{
            aktualny_bieg=0;
            System.out.println(aktualny_bieg);

        }}
        else
            throw new SprzegloException();

    }

    public int aktualne_przelozenie() {

        return this.aktualne_przelozenie;
    }

    public int aktualny_bieg() {

        return this.aktualny_bieg;
    }
    public void setAktualny_bieg(int aktualny_bieg){

        this.aktualny_bieg=aktualny_bieg;
    }
    public void ObliczPrzelozenie() {

        aktualne_przelozenie = aktualne_przelozenie + aktualny_bieg;
        System.out.println(aktualne_przelozenie);
    }
}