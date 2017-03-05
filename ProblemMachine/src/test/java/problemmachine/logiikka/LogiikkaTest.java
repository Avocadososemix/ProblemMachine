/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lkaranko
 */
public class LogiikkaTest {

    private Logiikka logic;

    public LogiikkaTest() {

    }

    @Before
    public void setUp() {
        logic = new Logiikka();
    }

    @Test
    public void testKaynnista() {
        assertEquals(logic.getTehtavat().getTehtavienLkmListalla(), 0);
        logic.kaynnista("kysymyksetTesti.txt");
        assertNotNull(logic.getTehtavat().getTehtavienLkmListalla());
    }

    @Test
    public void testHaeTehtava() {
        logic.kaynnista("kysymyksetTesti.txt");
        logic.haeTehtava();
        assertEquals(logic.getKysymysMuuttujilla(), "TestiKysymys? 2 ");

    }

    @Test
    public void testGetKysymysMuuttujilla() {
        assertEquals(logic.getKysymysMuuttujilla(), null);
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getKysymysMuuttujilla(), null);
        logic.haeTehtava();
        assertEquals(logic.getKysymysMuuttujilla(), "TestiKysymys? 2 ");
    }

    @Test
    public void testGetVastausMuuttujilla() {
        assertEquals(logic.getVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.haeTehtava();
        assertEquals(logic.getVastausMuuttujilla(), " TestiVastaus 6 ");
    }

    @Test
    public void testGetLaajaVastausMuuttujilla() {
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.haeTehtava();
        assertEquals(logic.getLaajaVastausMuuttujilla(), "TestiMallivastaus 2*3.0 = 6");
    }

    @Test
    public void testTarkistaVastaus() {
        assertEquals(logic.getVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        assertFalse(logic.tarkistaVastaus(" TestiVastaus 6 "));
        logic.haeTehtava();
        assertEquals(logic.getVastausMuuttujilla(), " TestiVastaus 6 ");
        assertTrue(logic.tarkistaVastaus(" TestiVastaus 6 "));
    }

    @Test
    public void testGetPisteet() {
        assertEquals(logic.getPisteet(), "0");
        logic.kaynnista("kysymyksetTesti.txt");
        logic.haeTehtava();
        logic.tarkistaVastaus(" TestiVastaus 6 ");
        assertEquals(logic.getPisteet(), "1");
    }

    @Test
    public void testPaloitteleTehtava() {
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        assertEquals(logic.getKysymysMuuttujilla(), null);
        assertEquals(logic.getVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        assertEquals(logic.getKysymysMuuttujilla(), null);
        assertEquals(logic.getVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.haeTehtava();
        assertEquals(logic.getVastausMuuttujilla(), " TestiVastaus 6 ");
        assertEquals(logic.getLaajaVastausMuuttujilla(), "TestiMallivastaus 2*3.0 = 6");
        assertEquals(logic.getKysymysMuuttujilla(), "TestiKysymys? 2 ");

    }

    @Test
    public void testAnnetaanSattumanvaraiset() {
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Valitse ensin kysymyssarja :)");
        logic.haeTehtava();
        assertEquals(logic.getLaajaVastausMuuttujilla(), "TestiMallivastaus 2*3.0 = 6");
    }

    @Test
    public void testVaihdaArvotMuuttujiin() {
        assertEquals(logic.getKysymysMuuttujilla(), null);
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getKysymysMuuttujilla(), null);
        logic.haeTehtava();
        assertEquals(logic.getKysymysMuuttujilla(), "TestiKysymys? 2 ");
    }

    @Test
    public void testLasketaanVastaukset() {
        assertEquals(logic.lasketaanVastaukset(" TestiMallivastaus 2*3.0 = {2*3.0} "), " TestiMallivastaus 2*3.0 = 6 ");
    }
}
