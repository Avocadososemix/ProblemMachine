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

    Logiikka logic;
    Tehtavat tehtava;

    public LogiikkaTest() {

    }

    @Before
    public void setUp() {
        logic = new Logiikka();
        tehtava = new Tehtavat();
    }

    @Test
    public void testKaynnista() {
        logic.kaynnista("kysymyksetMatematiikka.txt");
        assertNotNull(tehtava.getTehtavienLkmListalla());
    }

    @Test
    public void testHaeTehtava() {
        System.out.println("haeTehtava");
        Logiikka instance = new Logiikka();
        instance.haeTehtava();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of getKysymysMuuttujilla method, of class Logiikka.
//     */
//    @Test
//    public void testGetKysymysMuuttujilla() {
//        System.out.println("getKysymysMuuttujilla");
//        Logiikka instance = new Logiikka();
//        String expResult = "";
//        String result = instance.getKysymysMuuttujilla();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getVastausMuuttujilla method, of class Logiikka.
//     */
//    @Test
//    public void testGetVastausMuuttujilla() {
//        System.out.println("getVastausMuuttujilla");
//        Logiikka instance = new Logiikka();
//        String expResult = "";
//        String result = instance.getVastausMuuttujilla();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getLaajaVastausMuuttujilla method, of class Logiikka.
//     */
//    @Test
//    public void testGetLaajaVastausMuuttujilla() {
//        System.out.println("getLaajaVastausMuuttujilla");
//        Logiikka instance = new Logiikka();
//        String expResult = "";
//        String result = instance.getLaajaVastausMuuttujilla();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tarkistaVastaus method, of class Logiikka.
//     */
//    @Test
//    public void testTarkistaVastaus() {
//        System.out.println("tarkistaVastaus");
//        String annettuvastaus = "";
//        Logiikka instance = new Logiikka();
//        boolean expResult = false;
//        boolean result = instance.tarkistaVastaus(annettuvastaus);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPisteet method, of class Logiikka.
//     */
//    @Test
//    public void testGetPisteet() {
//        System.out.println("getPisteet");
//        Logiikka instance = new Logiikka();
//        String expResult = "";
//        String result = instance.getPisteet();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
