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
public class SatunnaisuusTest {
    
    private Satunnaisuus sattuma;
    
    /**
     *
     */
    public SatunnaisuusTest() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        sattuma = new Satunnaisuus();
    }

    /**
     *
     */
    @Test
    public void testAnnaSattumanvarainenInt() {
        assertTrue(sattuma.annaSattumanvarainenInt(1,1) == 1);
        
    }

    /**
     *
     */
    @Test
    public void testAnnaSattumanvarainenDouble() {
        assertTrue(1.0 == sattuma.annaSattumanvarainenDouble(1.0,1.0));
        
    }
    
}
