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
public class IntVaiDoubleTest {

    private boolean kumpi;
    private int arvoInt;
    private double arvoDouble;

    public IntVaiDoubleTest() {
    }

    @Before
    public void setUp() {
        boolean kumpi = true;
        int arvoInt = 1;
        double arvoDouble = 1.0;
    }

    /**
     * Test of onkoInt method, of class IntVaiDouble.
     */
    @Test
    public void testOnkoInt() {

        if (kumpi == (boolean) kumpi) {
            assertTrue(true);
        }

    }

    /**
     * Test of IntSeOn method, of class IntVaiDouble.
     */
    @Test
    public void testIntSeOn() {
        if (arvoInt == (int) arvoInt) {
            assertTrue(true);
        }
    }

    /**
     * Test of DoubleSeOn method, of class IntVaiDouble.
     */
    @Test
    public void testDoubleSeOn() {
        if (arvoDouble == (double) arvoDouble) {
            assertTrue(true);
        }
    }

    /**
     * Test of toString method, of class IntVaiDouble.
     */
    @Test
    public void testToStringInt() {
        if (kumpi = true) {
            IntVaiDouble testeri = new IntVaiDouble(1);
            assertEquals("1", testeri.toString());
        }

    }

    @Test
    public void testToStringDouble() {
        kumpi = false;
        IntVaiDouble testeri = new IntVaiDouble(1.0);
        assertEquals("1.0", testeri.toString());

    }

}
