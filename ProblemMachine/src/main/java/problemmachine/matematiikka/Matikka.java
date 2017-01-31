/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.matematiikka;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lkaranko
 */
public class Matikka {

    List<String> tehtavalista = new ArrayList();
    List<Integer> tehdytTehtavat = new ArrayList();

//
//    public String trigonometria() {
//        System.out.println("Mikä on kolmion ");
//    }
//
//    public String flavourText() {
//
//    }
//
    public void lueTiedosto() {
        InputStream inputti = getClass().getResourceAsStream("kysymykset.txt");
        Scanner lukija = new Scanner(inputti);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            tehtavalista.add(rivi);
        }

    }

    public String valitseSattumanvarainenTehtava() {
        return tehtavalista.get(annaSattumanvarainenInt(tehtavalista.size() - 1));
    }

    public String valitseTehtava(int tehtavanro) {
        return tehtavalista.get(tehtavanro);
    }
//    
//    public String paloitaTehtava() {
//        
//    }

    public double annaSattumanvarainenDouble(int min, int max) {
        Random r = new Random();
        double randomLuku = min + (max - min) * r.nextDouble();
        return randomLuku;
    }

    public int annaSattumanvarainenInt(int max) {
        Random r = new Random();
        int randomLuku = r.nextInt(max);
        return randomLuku;
    }

}
