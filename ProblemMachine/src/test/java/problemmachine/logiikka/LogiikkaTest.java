/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import problemmachine.tehtavat.Tehtavat;

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
        assertEquals(logic.getKysymysMuuttujilla(), "TestiKysymys? 1 ");

    }

    @Test
    public void testGetKysymysMuuttujilla() {
        assertEquals(logic.getKysymysMuuttujilla(), null);
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getKysymysMuuttujilla(), null);
        logic.haeTehtava();
        assertEquals(logic.getKysymysMuuttujilla(), "TestiKysymys? 1 ");
    }

    @Test
    public void testGetVastausMuuttujilla() {
        assertEquals(logic.getVastausMuuttujilla(), "Tälle tehtävälle ei ole vastausta");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getVastausMuuttujilla(), "Tälle tehtävälle ei ole vastausta");
        logic.haeTehtava();
        assertEquals(logic.getVastausMuuttujilla(), " TestiVastaus 4 ");
    }

    @Test
    public void testGetLaajaVastausMuuttujilla() {
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Tälle tehtävälle ei ole mallivastausta");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getLaajaVastausMuuttujilla(), "Tälle tehtävälle ei ole mallivastausta");
        logic.haeTehtava();
        assertEquals(logic.getLaajaVastausMuuttujilla(), "TestiMallivastaus 1+3 = 4");
    }

    @Test
    public void testTarkistaVastaus() {
        assertEquals(logic.getVastausMuuttujilla(), "Tälle tehtävälle ei ole vastausta");
        logic.kaynnista("kysymyksetTesti.txt");
        assertEquals(logic.getVastausMuuttujilla(), "Tälle tehtävälle ei ole vastausta");
        assertFalse(logic.tarkistaVastaus(" TestiVastaus 4 "));
        logic.haeTehtava();
        assertEquals(logic.getVastausMuuttujilla(), " TestiVastaus 4 ");
        assertTrue(logic.tarkistaVastaus(" TestiVastaus 4 "));
    }

    @Test
    public void testGetPisteet() {
        assertEquals(logic.getPisteet(), "0");
        logic.kaynnista("kysymyksetTesti.txt");
        logic.haeTehtava();
        logic.tarkistaVastaus(" TestiVastaus 4 ");
        assertEquals(logic.getPisteet(), "1");
    }
//
//    @Test
//    public void testPaloitteleTehtava() {
//        String sanoja = "nakki | takki | hattu|";
//        logic.paloitteleTehtava(sanoja);
//        
//    }

//    /**
//     * Test of annetaanSattumanvaraiset method, of class Logiikka.
//     */
//    @Test
//    public void testAnnetaanSattumanvaraiset() {
//        System.out.println("annetaanSattumanvaraiset");
//        String[] osat = null;
//        Logiikka instance = new Logiikka();
//        instance.annetaanSattumanvaraiset(osat);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testVaihdaArvotMuuttujiin() {
        logic.kaynnista("KysymyksetTesti.txt");
        logic.haeTehtava();
        
        logic.vaihdaArvotMuuttujiin("$A $B");
    }

    @Test
    public void testLasketaanVastaukset() {
        assertEquals(logic.lasketaanVastaukset(" TestiMallivastaus 1+3 = {1+3} "), " TestiMallivastaus 1+3 = 4 ");
    }
}
