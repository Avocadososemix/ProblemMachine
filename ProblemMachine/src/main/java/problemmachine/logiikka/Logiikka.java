/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import problemmachine.tehtavat.Tehtavat;

/**
 *
 * @author lkaranko
 */
public class Logiikka {

    Tehtavat tehtava = new Tehtavat();

    private HashMap<Character, IntVaiDouble> muuttujat = new HashMap<>();
    private String kysymys;
    private String vastaus;
    private String laajaVastaus;

    private int muuttujienlkm = 0;
    private int oikeatVastaukset = 0;
    private int vaaratVastaukset = 0;

    DecimalFormat format = new DecimalFormat("#.##");

    public Logiikka() {

    }

    public void kaynnista(String nimi) {
        tehtava.lueTiedosto(nimi);
    }

    public void haeTehtava() {
        System.out.println("Suoritetaan satunnaisen tehtavan haku");
        paloitteleTehtava(tehtava.valitseSattumanvarainenTehtava());
//        nykyinenTehtava = matematiikka.valitseSattumanvarainenTehtava();
//        System.out.println(nykyinenTehtava);
    }

    //tässä pitäisi estää käyttäjän hakemasta tehtävänumeroilla joilla ei löydy
    //tehtäviä. Käytetään getTehtavienLkmListalla() metodia.
    public void haeTehtava(int tehtavanro) {
        vastaus = "$";
        System.out.println("Tehtavan haku arvolla " + tehtavanro);
        paloitteleTehtava(tehtava.valitseTehtava(tehtavanro));

    }

    //osa 1 = tehtävä; osa 2 = vastaus; osa 3 = tehtävä avattuna; osa 4 = vaikeusaste/aihealue.
    //pitäisiköhän tässä tallentaa osat yleisiin muuttujiin?
    //tehtavan alkuun kaikki muuttujat? tai loppuun?
    public void paloitteleTehtava(String tehtavaOsat) {
        System.out.println("Ositellaan tehtävä-String");
        System.out.println(tehtavaOsat);
        String[] osat = tehtavaOsat.split("\\|");
        System.out.println("-osat jaettu, osia pitäisi olla 4, osia on " + osat.length);
        kysymys = osat[0];
        System.out.println("-kysymys määritelty");
        vastaus = (osat[1]);
        System.out.println("-vastaus määritelty");
        laajaVastaus = osat[2];
        System.out.println("-laajavastaus määritelty");
        if (!osat[3].trim().isEmpty()) {
        osat = osat[3].split(",");
        muuttujienlkm = osat.length;
        System.out.println("-muuttujienlkm määritelty");
        annetaanSattumanvaraiset(osat);
        }

    }

    public void annetaanSattumanvaraiset(String[] osat) {
        System.out.println("Valitaan satunnaiset arvot tehtävään");
        IntVaiDouble[] kirjainmuuttujat = new IntVaiDouble[osat.length];
        for (int i = 0; i < osat.length; i++) {
            String[] minmax = osat[i].split("-");
            if (minmax[i].contains(".")) {
                System.out.println("-Koitetaan antaa sattumanvarainen double");
                System.out.println("-Minimi on " + minmax[0] + " ja maksimi " + minmax[1]);
                kirjainmuuttujat[i] = new IntVaiDouble(annaSattumanvarainenDouble(
                        Double.parseDouble(minmax[0]),
                        Double.parseDouble(minmax[1])));

            } else {
                System.out.println("-koitetaan antaa sattumanvarainen int");
                System.out.println("-Minimi on " + minmax[0] + " ja maksimi " + minmax[1]);
                kirjainmuuttujat[i] = new IntVaiDouble(annaSattumanvarainenInt(
                        Integer.valueOf(minmax[0].trim()), Integer.valueOf(minmax[1].trim())));
                System.out.println("Satunnaisarvo annettu");
            }
        }
        System.out.println("-Asetetaan muuttujat taulukkoon");
        for (char i = 0; i < osat.length; i++) {
            muuttujat.put((char) (i + 'A'), kirjainmuuttujat[i]);
        }
        System.out.println("-muuttujia on tallennettuna " + muuttujat.size());
    }

    public int annaSattumanvarainenInt(int min, int max) {
        System.out.println("Keksitään sattumanvarainen luku väliltä " + min + " ja " + max);
        int randomLuku = min + (int) (Math.random() * ((max - min) + 1));
        return randomLuku;
    }

    public double annaSattumanvarainenDouble(double min, double max) {
        double randomLuku = min + (Math.random() * ((max - min) + 1));
        return randomLuku;
    }

    public String getKysymys() {
        return kysymys;
    }

    public String getKysymysMuuttujilla() {
        for (char i = 0; i < muuttujienlkm; i++) {
            kysymys = kysymys.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }
        return kysymys;
    }

    public String getVastaus() {
        return vastaus;
    }

    public String getVastausMuuttujilla() {
        if (!vastaus.contains("$")) {
            return vastaus;
        }
        format.setDecimalSeparatorAlwaysShown(false);
        for (char i = 0; i < muuttujienlkm; i++) {
            vastaus = vastaus.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }
        return laskin(vastaus);
    }

    public String getLaajaVastaus() {
        return laajaVastaus;
    }

    public String getLaajaVastausMuuttujilla() {
        for (char i = 0; i < muuttujienlkm; i++) {
            laajaVastaus = laajaVastaus.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }

        return (laajaVastaus.trim());
    }

    public boolean tarkistaVastaus(String annettuvastaus) {
        System.out.println("Annettu vastaus on " + annettuvastaus);
        System.out.println("Oikea vastaus on " + getVastausMuuttujilla());
        String vastausTrim = annettuvastaus.trim();
        if (vastausTrim.equals(getVastausMuuttujilla().trim())) {
            oikeatVastaukset++;
            return true;
        } else {
            vaaratVastaukset++;
            return false;
        }
    }

    public String laskin(String input) {
        format.setDecimalSeparatorAlwaysShown(false);
        format.setRoundingMode(RoundingMode.CEILING);
//        System.out.println("Aluksi input on " + input);
        try {
            ScriptEngineManager manageri = new ScriptEngineManager();
            ScriptEngine engine = manageri.getEngineByName("JavaScript");
            String palaute = engine.eval(input).toString();
            if (palaute.contains(".")) {
                vastaus = format.format(Double.parseDouble(palaute));
                return vastaus;
            } else {
                vastaus = palaute;
                return vastaus;
            }
        } catch (ScriptException | NumberFormatException e) {
            System.out.println(e);
        }
        return "";
    }

}
