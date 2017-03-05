/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author lkaranko
 */
public class Satunnaisuus {

    private Random r;

    /**
     * Konstruktorissa luodaan uusi Satunnaisuus luokka-olio, parametriksi
     * voidaan antaa random-olio junit-testaamista varten
     */
    public Satunnaisuus() {
        this(new Random());
    }

    public Satunnaisuus(Random r) {
        this.r = r;
    }

    /**
     * Metodi palauttaa sattumanvaraisen int-luvun saatujen arvojen väliltä,
     * mukaan lukien parametreinä saadut arvot.
     *
     *
     * @param min Integer, pienin mahdollinen arvottava luku.
     * @param max Integer, suurin mahdollinen arvottava luku.
     *
     * @return Palaute on sattumanvarainen int-tyyppinen arvo saatujen
     * parametrien väliltä mukaan lukien parametrien arvot.
     */
    public int annaSattumanvarainenInt(int min, int max) {
        int randomLuku = r.nextInt(1+max-min) + min;
        return randomLuku;
    }

    /**
     * Metodi palauttaa sattumanvaraisen double-luvun saatujen arvojen väliltä,
     * mukaan lukien parametreinä saadut arvot. Metodin palauttama arvo
     * muutetaan siten, että ylimääräiset desimaalit kahden desimaalin jälkeen
     * poistetaan format-oliota käyttämällä.
     *
     * @param min Double, pienin mahdollinen arvottava luku.
     * @param max Double, suurin mahdollinen arvottava luku.
     *
     * @return Palaute on sattumanvarainen double-tyyppinen arvo saatujen
     * parametrien väliltä mukaan lukien parametrien arvot.
     */
    public double annaSattumanvarainenDouble(double min, double max) {
        double randomLuku = min + (max - min) * r.nextDouble();
        DecimalFormat format = new DecimalFormat("#.##");
        String formatoitu = format.format(randomLuku);
        formatoitu = formatoitu.replaceAll(",", ".");
        randomLuku = Double.parseDouble(formatoitu);
        return randomLuku;
    }

}
