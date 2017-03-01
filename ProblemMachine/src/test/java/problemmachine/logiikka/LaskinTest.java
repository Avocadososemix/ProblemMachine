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
public class LaskinTest {

    private Laskin laskija;

    /**
     *
     */
    public LaskinTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        laskija = new Laskin();
    }

    /**
     *
     */
    @Test
    public void testLaskinYleiset() {
        assertEquals(laskija.laskin("3*3"), "9");
        assertEquals(laskija.laskin("3%2"), "1");
        assertEquals(laskija.laskin("15/3"), "5");
        assertEquals(laskija.laskin("(((3)))"), "3");

    }

    @Test
    public void testLaskinDouble() {
        assertEquals(laskija.laskin("3.0-1.5"), "1,5");
    }

    @Test
    public void testLaskinMuunnettunaIntegereiksi() {
        assertSame(Integer.parseInt(laskija.laskin("1+2")), 3);
    }

    @Test
    public void testLaskinNegatiivisilla() {
        assertEquals(laskija.laskin("-1+(-3)"), "-4");
    }

}
