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
        logic.kaynnista("kysymyksetTesti");
        assertNotNull(logic.getTehtavat().getTehtavienLkmListalla());
    }

    /**
     * Test of haeTehtava method, of class Logiikka.
     */
    @Test
    public void testHaeTehtava() {
        logic.kaynnista("kysymyksetTesti");
        logic.haeTehtava();
        
    }

    /**
     * Test of getKysymysMuuttujilla method, of class Logiikka.
     */
    @Test
    public void testGetKysymysMuuttujilla() {
        System.out.println("getKysymysMuuttujilla");
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.getKysymysMuuttujilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVastausMuuttujilla method, of class Logiikka.
     */
    @Test
    public void testGetVastausMuuttujilla() {
        System.out.println("getVastausMuuttujilla");
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.getVastausMuuttujilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaajaVastausMuuttujilla method, of class Logiikka.
     */
    @Test
    public void testGetLaajaVastausMuuttujilla() {
        System.out.println("getLaajaVastausMuuttujilla");
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.getLaajaVastausMuuttujilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tarkistaVastaus method, of class Logiikka.
     */
    @Test
    public void testTarkistaVastaus() {
        System.out.println("tarkistaVastaus");
        String annettuvastaus = "";
        Logiikka instance = new Logiikka();
        boolean expResult = false;
        boolean result = instance.tarkistaVastaus(annettuvastaus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPisteet method, of class Logiikka.
     */
    @Test
    public void testGetPisteet() {
        System.out.println("getPisteet");
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.getPisteet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paloitteleTehtava method, of class Logiikka.
     */
    @Test
    public void testPaloitteleTehtava() {
        System.out.println("paloitteleTehtava");
        String tehtavaOsat = "";
        Logiikka instance = new Logiikka();
        instance.paloitteleTehtava(tehtavaOsat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of annetaanSattumanvaraiset method, of class Logiikka.
     */
    @Test
    public void testAnnetaanSattumanvaraiset() {
        System.out.println("annetaanSattumanvaraiset");
        String[] osat = null;
        Logiikka instance = new Logiikka();
        instance.annetaanSattumanvaraiset(osat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vaihdaArvotMuuttujiin method, of class Logiikka.
     */
    @Test
    public void testVaihdaArvotMuuttujiin() {
        logic.vaihdaArvotMuuttujiin("$A $B");
    }

    /**
     * Test of lasketaanVastaukset method, of class Logiikka.
     */
    @Test
    public void testLasketaanVastaukset() {
        System.out.println("lasketaanVastaukset");
        String syote = "";
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.lasketaanVastaukset(syote);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
