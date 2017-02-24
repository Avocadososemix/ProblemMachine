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
    Random r;

    public Tehtavat(Random r) {
        this.r = r;
    }

    public Tehtavat() {
        this(new Random());
    }

    public void lueTiedosto(String lahdetiedosto) {
        tehtavalista.clear();
        tehdytTehtavat.clear();
        InputStream inputti = getClass().getResourceAsStream(lahdetiedosto);
        Scanner lukija = new Scanner(inputti);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            tehtavalista.add(rivi);
        }

    }

    public String valitseSattumanvarainenTehtava() {
//        System.out.println("Valitaan satunnainen tehtävä");
        return tehtavalista.get(valitseSattumanvarainenTehtavaLogiikka(tehtavalista.size()));
    }

    public String valitseTehtava(int tehtavanro) {
//        System.out.println("Valitaan tehtävä " + tehtavanro);
        return tehtavalista.get(tehtavanro);
    }

    public double annaSattumanvarainenDouble(int min, int max) {
        double randomLuku = min + (max - min) * r.nextDouble();
        return randomLuku;
    }

    public int valitseSattumanvarainenTehtavaLogiikka(int max) {
//        System.out.println("Arvotaan luku satunnaisen tehävän valitsemista varten. Int max on " + max);
        int randomLuku = r.nextInt(max);
        if (tehdytTehtavat.contains(randomLuku) && tehdytTehtavat.size() != tehtavalista.size()) {
            //tässä pienennetään todennäköisyyttä että saadaan uudestaan jo tehty tehtävä.
            //Kun kaikki tehtävät on jo tehty, tätä iffiä ei sovelleta enää.
            randomLuku = r.nextInt(max);
        }
        return randomLuku;
    }

    public int getTehtavienLkmListalla() {
        return tehtavalista.size();
    }

}
