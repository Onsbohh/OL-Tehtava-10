
package org.example;

/**
 * Pelaaja-luokka, joka pitää kirjaa pelaajan voitoista ja valinnoista.
 * @author Ira Dook
 */
public class Pelaaja {
    private int voitot;               // Voittojen lukumäärä
    private final int pelaajanNumero; // Pelaajan numero
    private String valinta;           // Pelaajan valinta

    /**
     * Konstruktori, joka luo uuden pelaajan ja asettaa pelaajan numeron.
     * @param pelaajanNumero Pelaajan numero
     */
    public Pelaaja(int pelaajanNumero) {
        voitot = 0;
        this.pelaajanNumero = pelaajanNumero;
    }

    /**
     * Metodi, joka lisää pelaajalle voiton.
     */
    public void setVoitot() {
        voitot++;
    }

    /**
     * Metodi, joka palauttaa pelaajan voittojen lukumäärän.
     * @return Pelaajan voittojen lukumäärä
     */
    public int getVoitot() {
        return voitot;
    }

    /**
     * Metodi, joka palauttaa pelaajan numeron.
     * @return Pelaajan numero
     */
    public int getPelaajanNumero() {
        return pelaajanNumero;
    }

    /**
     * Metodi, joka asettaa pelaajan valinnan.
     * @return valinta Pelaajan valinta
     */
    public String getValinta() {
        return valinta;
    }

    /**
     * Metodi, joka palauttaa pelaajan valinnan.
     * Katso, että valinta on joko "kivi", "paperi" tai "sakset".
     * @param valinta Pelaajan valinta
     */
    public void setValinta(String valinta) {
        if (valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset")){
            this.valinta = valinta;
        }   else {
            System.out.println("Virheellinen valinta!");
        }
    }
}
