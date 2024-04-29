import org.example.Pelaaja;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PelaajaTest {
    Pelaaja p1;

    @BeforeEach
    public void setUp() {
        p1 = new Pelaaja(1);
    }

    @Test
    public void voitonLisäysToimii() {
        p1.setVoitot();
        assertEquals(1, p1.getVoitot());
    }

    @Test
    public void voitonLisäysEiToimi() {
        p1.setVoitot();
        p1.setVoitot();
        assertNotEquals(1, p1.getVoitot());
    }

    @Test
    public void pelaajanNumeroToimii() {
        assertEquals(1, p1.getPelaajanNumero());
    }

    @Test
    public void pelaajanValintaToimii() {
        p1.setValinta("kivi");
        assertEquals("kivi", p1.getValinta());
    }

    @Test
    public void pelaajanValintaEiToimi() {
        p1.setValinta("kivi");
        assertNotEquals("paperi", p1.getValinta());
    }

    @Test
    public void pelaajanValintaVäärä() {
        p1.setValinta("kala");
        assertNotEquals("", p1.getValinta());
    }

    @Test
    public void pelaajanValintaTyhjä() {
        p1.setValinta("");
        assertNotEquals("", p1.getValinta());
    }
}
