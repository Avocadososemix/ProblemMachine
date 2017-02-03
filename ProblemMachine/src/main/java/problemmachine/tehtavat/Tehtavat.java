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

/**
 *
 * @author lkaranko
 */
public class Tehtavat {

    List<String> tehtavalista = new ArrayList();
    List<Integer> tehdytTehtavat = new ArrayList();

    public void lueTiedosto() {
        InputStream inputti = getClass().getResourceAsStream("kysymykset.txt");
        Scanner lukija = new Scanner(inputti);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            tehtavalista.add(rivi);
        }

    }

    public String valitseSattumanvarainenTehtava() {
        return tehtavalista.get(valitseSattumanvarainenTehtava(tehtavalista.size() - 1));
    }

    public String valitseTehtava(int tehtavanro) {
        return tehtavalista.get(tehtavanro);
    }

    public double annaSattumanvarainenDouble(int min, int max) {
        Random r = new Random();
        double randomLuku = min + (max - min) * r.nextDouble();
        return randomLuku;
    }

    public int valitseSattumanvarainenTehtava(int max) {
        Random r = new Random();
        int randomLuku = r.nextInt(max);
        if (tehdytTehtavat.contains(randomLuku) && tehdytTehtavat.size() != tehtavalista.size()) {
            //tässä pienennetään todennäköisyyttä että saadaan uudestaan jo tehty tehtävä.
            //Kun kaikki tehtävät on jo tehty, tätä iffiä ei sovelleta enää.
            randomLuku = r.nextInt(max);
        }
        return randomLuku;
    }

}
