package Samochod.Test;
import Samochod.SprzegloException;
import org.junit.Test;
import static org.junit.Assert.*;

import Samochod.Skrzynia_biegow;
import Samochod.Sprzeglo;


public class Skrzynia_biegowTest  {


    @Test
    public void zmien_bieg() throws SprzegloException {
        Sprzeglo sprzeglo = new Sprzeglo("jakies", 90, 3000);
        Skrzynia_biegow skrzynia = new Skrzynia_biegow("dobra", 60, 4000, 1, 6, 3444, new Sprzeglo("jakies", 90, 3000));
        assertEquals(1, skrzynia.aktualny_bieg());
        skrzynia.zwieksz_bieg();
        assertEquals(2, skrzynia.aktualny_bieg());
        Sprzeglo sprzeglo1 = new Sprzeglo("jakies", 90, 3000);
        Skrzynia_biegow skrzynia1 = new Skrzynia_biegow("dobra", 60, 4000, 7, 6, 3444, new Sprzeglo("jakies", 90, 3000));
        try{
            skrzynia1.zwieksz_bieg();
            throw new SprzegloException();
        }
        catch(SprzegloException e){
            System.out.println("error");
        }
    }

    @Test
    void obliczPrzelozenie() {
        Sprzeglo sprzeglo = new Sprzeglo("jakies", 90, 3000);
        Skrzynia_biegow skrzynia1 = new Skrzynia_biegow("dobra", 60, 4000, 1, 6, 3444, new Sprzeglo("jakies", 90, 3000));
        assertEquals(3444, skrzynia1.aktualne_przelozenie());

        skrzynia1.ObliczPrzelozenie();
        assertEquals(3445, skrzynia1.aktualne_przelozenie());

      /*  try {
            skrzynia1.ObliczPrzelozenie();
        } catch (Exception e) {
            System.err.println("bład");

        }
*/
    }
    @Test
    void getAktualnyBieg() {
        Skrzynia_biegow skrzynia2 = new Skrzynia_biegow("dobra", 60, 4000, 3, 6, 3444, new Sprzeglo("jakies", 90, 3000));
        assertEquals(3, skrzynia2.aktualny_bieg());
    }

    @Test
    void getAktualne_przelozenie() {
        Skrzynia_biegow skrzynia3= new Skrzynia_biegow("dobra", 60, 4000, 1, 6, 3477, new Sprzeglo("jakies", 90, 3000));
        assertEquals(3477, skrzynia3.aktualne_przelozenie());
    }


}