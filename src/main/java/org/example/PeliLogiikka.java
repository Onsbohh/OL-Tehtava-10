package org.example;

/**
 * PeliLogiikka-luokka, joka hoitaa pelin etenemisen.
 *
 * @author Onni Pajula
 */
public class PeliLogiikka {
    Pelaaja p1;             // Pelaaja 1
    Pelaaja p2;             // Pelaaja 2
    int pelatutPelit = 1;   // Pelattujen pelien lkm

    /**
     * Konstruktori, joka luo uuden pelilogiikan ja asettaa pelaajat.
     *
     * @param pelaajaYksi  Pelaaja 1
     * @param pelaajaKaksi Pelaaja 2
     */
    public PeliLogiikka(Pelaaja pelaajaYksi, Pelaaja pelaajaKaksi) {
        this.p1 = pelaajaYksi;
        this.p2 = pelaajaKaksi;
    }

    /**
     * Aloita peli ja pelaa eriä, kunnes jompikumpi pelaajista voittaa.
     */
    public void aloitaPeli() {
        int tasapelit = 0;  // Tasapelien lkm

        do {
            System.out.println("\nErä: "
                    + pelatutPelit + " =====================\n");

            System.out.println("Tasapelien lukumäärä: "
                    + tasapelit + "\n");

            // Valitaan pelaajan 1 valinta ja tallennetaan se pelaajaan.
            p1.setValinta(pelaajanValinta());
            p2.setValinta(pelaajanValinta());

            System.out.println("Pelaaja 1: " + p1.getValinta());
            System.out.println("Pelaaja 2: " + p2.getValinta());

            // Pelataan erä ja palautetaan voittaja tai null jos tasapeli.
            Pelaaja voittaja = pelaaErä(p1.getValinta(), p2.getValinta());

            System.out.println("Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            System.out.println("Pelaaja 2:llä koossa " + p2.getVoitot() + " voittoa.");

            // Jos voittaja on null, lisätään tasapelien lkm.
            if (voittaja == null) {
                tasapelit++;
            }

            pelatutPelit++;
        } while (!peliLoppui());
    }

    /**
     * Valitse randomilla kivi, paperi tai sakset
     *
     * @return Valinta string
     */
    public String pelaajanValinta() {
        String valinta = "";               // Alustetaan valinta.
        int c = (int) (Math.random() * 3); // Arvotaan luku 0-2.
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    /**
     * Pelaa erä ja palauttaa voittajan.
     *
     * @param p1Valinta Pelaajan 1 valinta
     * @param p2Valinta Pelaajan 2 valinta
     * @return Voittaja pelaaja
     */
    public Pelaaja pelaaErä(String p1Valinta, String p2Valinta) {
        // Tarkistetaan valinnat.
        valinnanValidointi(p1Valinta);
        valinnanValidointi(p2Valinta);

        // Kumpi pelaaja voitti erän.
        int voittaja = kumpiPelaajaVoitti(p1Valinta, p2Valinta);

        // Katsotaan kuka voitti ja lisätään voitto.
        if (voittaja == 1) {
            p1.setVoitot();
            System.out.println("\nPelaaja 1 voitti\n");
            return p1;
        } else if (voittaja == 2) {
            p2.setVoitot();
            System.out.println("\nPelaaja 2 voitti\n");
            return p2;
        } else {
            System.out.println("\nTasapeli");
            return null; // ei voittajaa.
        }
    }

    /**
     * Kumpi pelaaja voitti erän.
     *
     * @param p1Valinta Pelaajan 1 valinta
     * @param p2Valinta Pelaajan 2 valinta
     * @return Voittaja int
     */
    public int kumpiPelaajaVoitti(String p1Valinta, String p2Valinta) {
        // Tarkistetaan valinnat.
        valinnanValidointi(p1Valinta);
        valinnanValidointi(p2Valinta);

        // Kumpi pelaaja voitti erän.
        if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) {
            return p1.getPelaajanNumero(); // Pelaaja 1 voittaa.
        } else if (p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
            return p1.getPelaajanNumero();
        } else if (p1Valinta.equals("paperi") && p2Valinta.equals("kivi")) {
            return p1.getPelaajanNumero();
        } else if (p1Valinta.equals(p2Valinta)) {
            return 0; // Tasapeli.
        } else {
            return p2.getPelaajanNumero(); // Pelaaja 2 voittaa.
        }
    }

    /**
     * Tarkista, onko peli loppunut.
     *
     * @return True, jos peli on loppunut
     */
    public boolean peliLoppui() {
        // Jos jompikumpi pelaajista voittaa 3 erää, peli loppuu.
        if (p1.getVoitot() == 3 ) {
            System.out.println("\nPelaaja 1 voittaa." + " Eriä pelattiin " + pelatutPelit);
            return true;
        } else if (p2.getVoitot() == 3) {
            System.out.println("\nPelaaja 2 voittaa." + " Eriä pelattiin " + pelatutPelit);
            return true;
        }
        return false;
    }

    /**
     * Valinnan validointi.
     *
     * @param valinta Valinta
     * @throws IllegalArgumentException Virheellinen valinta
     */
    public void valinnanValidointi(String valinta) {
        // Tarkistetaan, että valinta on joko kivi, paperi tai sakset.
        if (!valinta.equals("kivi") && !valinta.equals("paperi") && !valinta.equals("sakset")) {
            // Heitetään virhe, jos valinta on väärä.
            throw new IllegalArgumentException("Virheellinen valinta. Valitse kivi, paperi tai sakset.");
        }
    }

    /**
     * Palauta pelaaja 1.
     * Käytetään testauksessa.
     * @return Pelaaja 1
     */
    public Pelaaja getP1() {
        return p1; // Palauta pelaaja 1.
    }

    /**
     * Palauta pelaaja 2.
     * Käytetään testauksessa.
     * @return Pelaaja 2
     */
    public Pelaaja getP2() {
        return p2; // Palauta pelaaja 2.
    }
}


