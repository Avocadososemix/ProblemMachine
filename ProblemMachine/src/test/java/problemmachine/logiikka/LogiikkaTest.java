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
        Logiikka logic = new Logiikka();
        
    }
    
    @Test
    public void testHaeTehtava_0args() {
        System.out.println("haeTehtava");
        Logiikka instance = new Logiikka();
        instance.haeTehtava();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testHaeTehtava_int() {
        System.out.println("haeTehtava");
        int tehtavanro = 0;
        Logiikka instance = new Logiikka();
        instance.haeTehtava(tehtavanro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPaloitteleTehtava() {
        System.out.println("paloitteleTehtava");
        String tehtavaOsat = "";
        Logiikka instance = new Logiikka();
        instance.paloitteleTehtava(tehtavaOsat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnnetaanSattumanvaraiset() {
        System.out.println("annetaanSattumanvaraiset");
        String[] osat = null;
        Logiikka instance = new Logiikka();
        instance.annetaanSattumanvaraiset(osat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnnaSattumanvarainenInt() {
        System.out.println("annaSattumanvarainenInt");
        int min = 0;
        int max = 0;
        Logiikka instance = new Logiikka();
        int expResult = 0;
        int result = instance.annaSattumanvarainenInt(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnnaSattumanvarainenDouble() {
        System.out.println("annaSattumanvarainenDouble");
        double min = 0.0;
        double max = 0.0;
        Logiikka instance = new Logiikka();
        double expResult = 0.0;
        double result = instance.annaSattumanvarainenDouble(min, max);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetKysymys() {
        System.out.println("getKysymys");
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.getKysymys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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

    @Test
    public void testGetVastaus() {
        System.out.println("getVastaus");
        Logiikka instance = new Logiikka();
        double expResult = 0.0;
        double result = instance.getVastaus();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLaajaVastaus() {
        System.out.println("getLaajaVastaus");
        Logiikka instance = new Logiikka();
        String expResult = "";
        String result = instance.getLaajaVastaus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
    
}
