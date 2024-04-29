import org.example.Pelaaja;
import org.example.PeliLogiikka;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PeliLogiikkaTest {

    PeliLogiikka peli;
    Pelaaja p1;
    Pelaaja p2;

    @BeforeEach
    public void setUp() {
        p1 = new Pelaaja(1);
        p2 = new Pelaaja(2);
        peli = new PeliLogiikka(p1, p2);
    }

    @Test
    public void aloitaPeliToimii() {
        assertDoesNotThrow(() -> peli.aloitaPeli());
    }

    @Test
    public void pelaajanValintaToimii() {
        String valinta = peli.pelaajanValinta();
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }

    @Test
    public void pelaaEräToimii() {
        Pelaaja voittaja = peli.pelaaErä("kivi", "sakset");
        assertEquals(1, voittaja.getPelaajanNumero());
        assertEquals(1, p1.getVoitot());
        assertEquals(0, p2.getVoitot());

        voittaja = peli.pelaaErä("sakset", "kivi");
        assertEquals(2, voittaja.getPelaajanNumero());
        assertEquals(1, p1.getVoitot());
        assertEquals(1, p2.getVoitot());

        voittaja = peli.pelaaErä("paperi", "paperi");
        assertNull(voittaja);
        assertEquals(1, p1.getVoitot());
        assertEquals(1, p2.getVoitot());
    }

    @Test
    public void kumpiPelaajaVoittiToimii() {
        assertEquals(1, peli.kumpiPelaajaVoitti("kivi", "sakset"));
        assertEquals(1, peli.kumpiPelaajaVoitti("sakset", "paperi"));
        assertEquals(1, peli.kumpiPelaajaVoitti("paperi", "kivi"));
        assertEquals(0, peli.kumpiPelaajaVoitti("kivi", "kivi"));
        assertEquals(0, peli.kumpiPelaajaVoitti("sakset", "sakset"));
        assertEquals(0, peli.kumpiPelaajaVoitti("paperi", "paperi"));
        assertEquals(2, peli.kumpiPelaajaVoitti("sakset", "kivi"));
        assertEquals(2, peli.kumpiPelaajaVoitti("paperi", "sakset"));
        assertEquals(2, peli.kumpiPelaajaVoitti("kivi", "paperi"));
    }

    @Test
    public void peliLoppuiToimii() {
        p1.setVoitot();
        p2.setVoitot();
        assertFalse(peli.peliLoppui());

        p1.setVoitot();
        p2.setVoitot();
        assertFalse(peli.peliLoppui());

        p1.setVoitot();
        assertTrue(peli.peliLoppui());
    }

    @Test
    public void valinnanValidointiToimii() {
        assertDoesNotThrow(() -> peli.valinnanValidointi("kivi"));
        assertDoesNotThrow(() -> peli.valinnanValidointi("paperi"));
        assertDoesNotThrow(() -> peli.valinnanValidointi("sakset"));
        assertThrows(IllegalArgumentException.class, () -> peli.valinnanValidointi("kala"));
    }

    @Test
    public void getP1Toimii() {
        assertEquals(p1, peli.getP1());
    }

    @Test
    public void getP2Toimii() {
        assertEquals(p2, peli.getP2());
    }
}
