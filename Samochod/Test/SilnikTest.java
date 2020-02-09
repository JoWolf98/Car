package Samochod.Test;
import Samochod.Silnik;

import org.junit.Test;

import static org.junit.Assert.*;

public class SilnikTest {

    @org.junit.Test
    public void uruchom() {
        Silnik a=new Silnik("aaa",23,1200,4000,800);
        a.uruchom();
        assertEqulas(800,a.getObroty());
    }

    private void assertEqulas(int i, int obroty) {
    }

    @org.junit.Test
    public void zatrzymaj() {
        Silnik a=new Silnik("aaa",23,1200,4000,900);
        a.uruchom();
        a.zatrzymaj();
        assertEquals(0, a.getObroty());
    }

    @org.junit.Test
    public void zwieksz_obroty() {
        Silnik a = new Silnik("aaa",23,1200,4000,900);
        a.uruchom();
        a.zwieksz_obroty();
        assertEquals(900, a.getObroty());
        a.zwieksz_obroty();
        a.zwieksz_obroty();
        assertEquals(1100, a.getObroty());
    }

    @org.junit.Test
    public void zmniejsz_obroty() {
        Silnik a = new Silnik("aaa",23,1200,4000,900);
        a.uruchom();
        a.zwieksz_obroty();
        a.zmniejsz_obroty();
        assertEquals(800, a.getObroty());
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        a.zmniejsz_obroty();
        assertEquals(0, a.getObroty());
    }
}