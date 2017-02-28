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

    public Satunnaisuus() {

    }

    public int annaSattumanvarainenInt(int min, int max) {
//        System.out.println("Keksitään sattumanvarainen luku väliltä " + min + " ja " + max);
        int randomLuku = min + (int) (Math.random() * ((max - min) + 1));
        return randomLuku;
    }

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
