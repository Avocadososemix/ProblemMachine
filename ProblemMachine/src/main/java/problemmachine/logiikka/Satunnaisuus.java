/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.text.DecimalFormat;

/**
 *
 * @author lkaranko
 */
public class Satunnaisuus {

    /**
     * Konstruktorissa luodaan uusi Satunnaisuus luokka-olio.
     */
    public Satunnaisuus() {

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
//        System.out.println("Keksitään sattumanvarainen luku väliltä " + min + " ja " + max);
        int randomLuku = min + (int) (Math.random() * ((max - min) + 1));
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
//        System.out.println("Keksitään double luku arvoväliltä " + min + " ja " + max);
        double randomLuku = min + (Math.random() * ((max - min) + 1));
        DecimalFormat format = new DecimalFormat("#.##");
        String formatoitu = format.format(randomLuku);
        formatoitu = formatoitu.replaceAll(",", ".");
        randomLuku = Double.parseDouble(formatoitu);
        return randomLuku;
    }

}
