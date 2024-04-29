package org.example;

/**
 *  Peli-luokka, joka käynnistää pelin ja luo pelaajat.
 * @author Ira Dook
 */
public class Peli {
    /**
     * Main-metodi, joka luo pelaajat ja aloittaa pelin.
     * @param args argumentit
     */
    public static void main(String args[]) {
        // Luodaan pelaajat
        Pelaaja p1 = new Pelaaja(1);
        Pelaaja p2 = new Pelaaja(2);

        // Luodaan pelilogiikka ja aloitetaan peli
        PeliLogiikka peli = new PeliLogiikka(p1, p2);
        peli.aloitaPeli();
    }
}
