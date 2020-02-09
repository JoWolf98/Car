package Samochod;

public class Samochod
{
    private Silnik silnik;
    private Sprzeglo sprzeglo;
    private Skrzynia_biegow skrzynia_biegow;
    private String kolor;
    private String nrRejestru;
    private String model;
    private String marka;
    private float predkosc_max;
    private int predkosc;


    public void wlacz(){

          sprzeglo.zalacz();
          silnik.uruchom();
        //  skrzynia_biegow.zwieksz_bieg();
          sprzeglo.rozlacz();
    }
    public void wylacz(){

        sprzeglo.zalacz();
        silnik.zatrzymaj();
        sprzeglo.rozlacz();
    }
    public void jazda() {
        sprzeglo.zalacz();
        //skrzynia_biegow.zwieksz_bieg();
        sprzeglo.rozlacz();

    }
    public String getModel(){

        return this.model;
    }
    public String getMarka(){

        return this.marka;
    }
    public String getNrRejestru(){

        return this.nrRejestru;
    }
    public float getPredkosc() {

        return this.predkosc;
    }
    public void setPredkosc(int predkosc){

        this.predkosc=predkosc;
    }

    public int oblicz_wage(){
     int waga = silnik.getWaga()+skrzynia_biegow.getWaga()+sprzeglo.getWaga();
     return waga;
    }

    public int aktualna_predkosc() {
        if (skrzynia_biegow.aktualny_bieg() == 0 && silnik.getObroty() == 0) {
            predkosc = 0;
        } else if(silnik.getObroty()==0)
            predkosc=0;
        else if(skrzynia_biegow.aktualny_bieg()==0)
            predkosc=0;
        else
            predkosc = (int) (skrzynia_biegow.aktualny_bieg() * 5 + silnik.getObroty() * 7);

    return predkosc;
    }
    public void aktualna_predkosc2() {
        if (skrzynia_biegow.aktualny_bieg() == 0 && silnik.getObroty() == 0) {
            predkosc = 0;
        } else if(silnik.getObroty()==0)
            predkosc=0;
        else if(skrzynia_biegow.aktualny_bieg()==0)
            predkosc=0;
        else
            predkosc = (int) (skrzynia_biegow.aktualny_bieg() * 5 + silnik.getObroty() * 7);


    }


    public Samochod(Silnik silnik, Sprzeglo sprzeglo, Skrzynia_biegow skrzynia_biegow, String kolor, String nrRejestru, String model, String marka, float predkosc_max) {
        this.silnik = silnik;
        this.sprzeglo = sprzeglo;
        this.skrzynia_biegow = skrzynia_biegow;
        this.kolor = kolor;
        this.nrRejestru = nrRejestru;
        this.model = model;
        this.marka = marka;
        this.predkosc_max = predkosc_max;
    }
}
