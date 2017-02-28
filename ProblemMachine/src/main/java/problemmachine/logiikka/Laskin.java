/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author lkaranko
 */
public class Laskin {

    /**
     * Oliomuuttuja format on käytössä, jotta voimme pyöristää sekä rajata
     * laskimen tuloksena saadun arvon 2 desimaalipisteen tarkkuudella.
     */
    private DecimalFormat format;

    /**
     * Konstruktori asettaa format-muuttujalle 2 desimaalipisteen tarkkuuden kun
     * tätä käytetään numeroiden (String-muodossa) formatoimiseen.
     */
    public Laskin() {
        format = new DecimalFormat("#.##");
    }

    /**
     * Metodi saa parametrinaan String-tyyppisen muuttujan, joka sisältää laskun
     * muodossa jonka ScriptEngine kykenee laskemaan. ScriptEnginen laskettua
     * annettu lasku-input, palautetaan lasketun laskun tulos. Mikäli laskun
     * tulos sisältää desimaalin, pyöristetään laskettu arvo ylöspäin ja
     * annetaan vastaus 2 desimaalipisteen tarkkuudella, muutoin palautetaan
     * arvo sellasenaan. Try-catch käytetty jotta saamme ScriptEnginen
     * toimimaan.
     *
     * @param input Laskettava lasku String-tyyppisenä oliona.
     *
     * @return annetun laskun tulos laskennan jälkeen.
     */
    public String laskin(String input) {
        format.setDecimalSeparatorAlwaysShown(false);
        format.setRoundingMode(RoundingMode.CEILING);
        try {
            ScriptEngineManager manageri = new ScriptEngineManager();
            ScriptEngine engine = manageri.getEngineByName("JavaScript");
            String palaute = engine.eval(input).toString();
            if (palaute.contains(".")) {
                input = format.format(Double.parseDouble(palaute));
                return input;
            } else {
                return palaute;
            }
        } catch (ScriptException | NumberFormatException e) {
            System.out.println(e);
        }
        return "";
    }

}
