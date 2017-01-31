/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.matematiikka;

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
public class MatikkaTest {

    public MatikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Matikka matematiikka = new Matikka();
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of annaSattumanvarainen method, of class matikka.
//     */
//    @Test
//    public void testAnnaSattumanvarainen() {
//
//    }
//
//    /**
//     * Test of lueTiedosto method, of class Matikka.
//     */
//    @Test
//    public void testLueTiedosto() {
//
//    }
//
//    /**
//     * Test of valitseSattumanvarainenTehtava method, of class Matikka.
//     */
//    @Test
//    public void testValitseSattumanvarainenTehtava() {
//
//    }
//
//    /**
//     * Test of valitseTehtava method, of class Matikka.
//     */
//    @Test
//    public void testValitseTehtava() {
//
//    }
//
//    /**
//     * Test of annaSattumanvarainenDouble method, of class Matikka.
//     */
//    @Test
//    public void testAnnaSattumanvarainenDouble() {
//
//    }

    /**
     * Test of annaSattumanvarainenInt method, of class Matikka.
     */
    @Test
    public void testAnnaSattumanvarainenInt() {
        Matikka matematiikka = new Matikka();
        int muuttuja =matematiikka.annaSattumanvarainenInt(1);
        assertTrue(0 <= muuttuja && muuttuja <= 1);
    }
}
