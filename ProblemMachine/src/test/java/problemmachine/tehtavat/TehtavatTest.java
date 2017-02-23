/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.tehtavat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import problemmachine.tehtavat.Tehtavat;
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
public class TehtavatTest {

    public TehtavatTest() {
    }
    
    private Tehtavat testeri;
    private RememberingRandom randomi;

    @Before
    public void setUp() {
        randomi = new RememberingRandom();
        testeri = new Tehtavat(randomi);
        
        testeri.lueTiedosto("kysymyksetMatematiikka.txt");
    }

//    @Test
//    public void testAnnaSattumanvarainenInt() {
//        Tehtavat testeri = new Tehtavat();
//        int muuttuja = testeri.valitseSattumanvarainenTehtava(1);
//        assertTrue(0 <= muuttuja && muuttuja <= 1);
//    }

    @Test
    public void testAnnaSattumanvarainenDouble() {
        
        double muuttuja = testeri.annaSattumanvarainenDouble(1, 10);
        assertTrue(randomi.getDoubleRandom().get(0) == muuttuja);
    }

    @Test
    public void testLueTiedosto() {
        List<String> tehtavalista = new ArrayList();
        int rivit = 0;
        String lahdetiedosto = "kysymyksetMatematiikka.txt";
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
        String tehtava0 = "\"Sinulla on \" + $A + \" kenkää, montako muurahaista"
                + " pystyt kengittämään?\" || \"Vastaus on \" + ((2-$A))/6 + \" "
                + "muurahaista.\" || \"Muurahaisella on 3 jalkaparia, joten vastaus"
                + " saadaan jakamalla kenkien lukumäärä kuudella.\" || 12-1300";
        assertTrue(testeri.valitseTehtava(0).equals(tehtava0));
    }
//
//    @Test
//    public void TestValitseSattumanvarainenTehtava() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void TestGetTehtavienLkmListalla() {
//        assertTrue(testeri.getTehtavienLkmListalla()
//    }
}
