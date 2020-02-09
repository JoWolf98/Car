package Samochod;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Silnik extends Komponent implements Runnable,Obserwowany{

    private Obserwator obserwator;

    private int maxObroty ;
    private int obroty;
    private Skrzynia_biegow skrzynia1;
    private int uruchomiony;


    public void setObroty(int obroty){

        this.obroty=obroty;
    }
    public void uruchom() {

        uruchomiony=1;
        obroty=100;
        System.out.println("silnik uruchomiony.");
        System.out.println("obroty = " + obroty);
    }

    public void zatrzymaj() {

        obroty = 0; //stop
        uruchomiony=0;
        System.out.println("silnik zatrzymany.");
        System.out.println("obroty = " + obroty);

    }

    public void zwieksz_obroty() {

        if(uruchomiony==1){
        obroty = obroty + 100;
        if (obroty > maxObroty) obroty = maxObroty;
        System.out.println("obroty = " + obroty);}
        else{
            obroty =0;
        }
    }

    public void zmniejsz_obroty() {
        if(uruchomiony==1){
        obroty = obroty - 100;
        if (obroty < 0) obroty = 0;
        System.out.println("obroty = " + obroty);}
        else
        {
            obroty=0;
        }

    }

    public int getObroty() {

        return this.obroty;
    }

    public int getMaxObroty(){

        return this.maxObroty;
    }
    public Silnik(String nazwa, int waga, float cena, int max_obroty,int obroty) {
        super(nazwa, waga, cena);
        this.maxObroty = max_obroty;
        this.obroty=obroty;
    }
/*
    public void zmienObroty() {
        if (uruchomiony == 1) {
            Random r = new Random();
            int losowa = 5 - (r.nextInt(9) + 1);
            if (obroty + losowa < maxObroty && obroty + losowa >=0) {
                obroty = obroty + losowa;
            } else if (obroty + losowa < 0) {
                obroty = 0;
            } else if (obroty + losowa > maxObroty) {
                obroty = maxObroty;
            }

        }
    }
    public void run() {

       while(true){

          if(uruchomiony==1){

          zmienObroty();
          //System.out.println(getObroty());
          try{
              sleep(100);
          }
          catch(InterruptedException e){
          }
          if(obserwator != null){
                 obserwator.inform();
      }}
      }
    }*/
public void run()
{

    while(true)
    {
        Random rand = new Random();
        int losowa = 5 - (rand.nextInt(9) + 1);

        if(uruchomiony==1)
        {
            if(obroty + losowa < maxObroty && obroty + losowa > 0)
                obroty += losowa;
            else if (obroty + losowa < 0)
                obroty = 0;
            else if (obroty + losowa >maxObroty)
                obroty = maxObroty;


            try { Thread.sleep(100);} catch (InterruptedException e) { }

            if(obserwator != null)
            {
                obserwator.inform();
            }

        }

    }
}
    public void subskrybuj(Obserwator o)
    {
        obserwator = o;
    } //moze byc max jeden obserwator

    public void odsubskrybuj(Obserwator o)
    {
        if (obserwator == o)
        {
            obserwator = null; //nie ma obserwatora
        }
    }
    public void inform() {obserwator.inform();}



    public static void main(String[] args) {

        Silnik b = new Silnik("dobry_sinik", 30, 2000, 8000,1000);
        Thread thread = new Thread(b);
        thread.start();
    }

}