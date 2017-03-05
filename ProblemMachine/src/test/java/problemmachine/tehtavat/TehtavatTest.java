/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.tehtavat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lkaranko
 */
public class TehtavatTest {

    public TehtavatTest() {
    }

    private Tehtavat testeri;
    private RememberingRandom randomi;

    @Before
    public void setUp() {
        randomi = new RememberingRandom();
        testeri = new Tehtavat(randomi);
        testeri.lueTiedosto("kysymyksetTesti.txt");
    }

    @Test
    public void testValitseSattumanvarainenPainotettu() {
        assertEquals((Integer) testeri.valitseSattumanvarainenPainotettu(100), randomi.getIntRandom().get(randomi.getIntRandom().size()-1));  
    }

    @Test
    public void testLueTiedosto() {
        List<String> tehtavalista = new ArrayList();
        int rivit = 0;
        String lahdetiedosto = "kysymyksetTesti.txt";
        InputStream inputti = getClass().getResourceAsStream(lahdetiedosto);
        Scanner lukija = new Scanner(inputti);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            tehtavalista.add(rivi);
            rivit++;
        }
        assertTrue(!(tehtavalista.isEmpty()));
        assertTrue(tehtavalista.get(0).getClass().equals(String.class));
        assertTrue(tehtavalista.size() == rivit);

    }

    @Test
    public void testValitseTehtava() {
        String tehtava0 = "TestiKysymys? $A | TestiVastaus {$A*$B} | "
                + "TestiMallivastaus $A*$B = {$A*$B} | 2-2, 3.0-3.0";
        assertTrue(testeri.valitseTehtava(0).equals(tehtava0));
    }

    @Test
    public void TestValitseSattumanvarainenTehtava() {
        assertFalse(testeri.valitseSattumanvarainenTehtava().isEmpty());
        assertTrue(testeri.valitseSattumanvarainenTehtava().getClass().equals(String.class));
        assertEquals(testeri.valitseSattumanvarainenTehtava(),"TestiKysymys? $A "
                + "| TestiVastaus {$A*$B} | TestiMallivastaus $A*$B = {$A*$B} | 2-2, 3.0-3.0");
    }

    @Test
    public void TestGetTehtavienLkmListalla() {
        assertNotNull(testeri.getTehtavienLkmListalla());
        assertEquals(testeri.getTehtavienLkmListalla(),1);
    }

}
