/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.text.DecimalFormat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import problemmachine.tehtavat.RememberingRandom;

/**
 *
 * @author lkaranko
 */
public class SatunnaisuusTest {

    private Satunnaisuus sattuma;
    private RememberingRandom randomi;

    public SatunnaisuusTest() {
    }

    @Before
    public void setUp() {
        randomi = new RememberingRandom();
        sattuma = new Satunnaisuus(randomi);
    }

    @Test
    public void testAnnaSattumanvarainenInt() {
        assertEquals((Integer) sattuma.annaSattumanvarainenInt(0, 100),
                randomi.getIntRandom().get(randomi.getIntRandom().size() - 1));

    }

    @Test
    public void testAnnaSattumanvarainenDouble() {

        assertEquals((Double) sattuma.annaSattumanvarainenDouble(0, 100),
                randomi.getDoubleRandom().get(randomi.getDoubleRandom().size() - 1) * 100, 0.01);
    }

}
