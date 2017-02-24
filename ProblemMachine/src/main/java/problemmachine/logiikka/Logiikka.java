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
    Satunnaisuus sattuma = new Satunnaisuus();

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
        vastaus = "$";
        paloitteleTehtava(tehtava.valitseSattumanvarainenTehtava());
    }

    public void haeTehtava(int tehtavanro) {
        if (tehtavanro + 1 > tehtava.getTehtavienLkmListalla()) {
            tehtavanro = 0;
        }
        vastaus = "$";
        paloitteleTehtava(tehtava.valitseTehtava(tehtavanro));

    }

    //osa 1 = tehtävä; osa 2 = vastaus; osa 3 = tehtävä avattuna; osa 4 = vaikeusaste/aihealue.
    public void paloitteleTehtava(String tehtavaOsat) {
        System.out.println(tehtavaOsat);
        String[] osat = tehtavaOsat.split("\\|");
        kysymys = osat[0];
        vastaus = (osat[1]);
        laajaVastaus = osat[2];
        if (!osat[3].trim().isEmpty()) {
            osat = osat[3].split(",");
            muuttujienlkm = osat.length;
//            System.out.println("-muuttujienlkm määritelty:" + muuttujienlkm);
            annetaanSattumanvaraiset(osat);
        }

    }

    public void annetaanSattumanvaraiset(String[] osat) {
//        System.out.println("Valitaan satunnaiset arvot tehtävään");
        IntVaiDouble[] kirjainmuuttujat = new IntVaiDouble[osat.length];
        for (int i = 0; i < osat.length; i++) {
            String[] minmax = osat[i].split("-");
            if (minmax[0].contains(".") || minmax[1].contains(".")) {
//                System.out.println("-Koitetaan antaa sattumanvarainen double");
//                System.out.println("-Minimi on " + minmax[0].trim() + " ja maksimi " + minmax[1].trim());
                kirjainmuuttujat[i] = new IntVaiDouble(sattuma.annaSattumanvarainenDouble(
                        Double.parseDouble(minmax[0].replaceAll("(^\\h*)|(\\h*$)", "")),
                        Double.parseDouble(minmax[1].trim())));

            } else {
                System.out.println("-koitetaan antaa sattumanvarainen int");
                System.out.println("-Minimi on " + minmax[0] + " ja maksimi " + minmax[1]);
                kirjainmuuttujat[i] = new IntVaiDouble(sattuma.annaSattumanvarainenInt(
                        Integer.valueOf(minmax[0].trim()), Integer.valueOf(minmax[1].trim())));
//                System.out.println("Satunnaisarvo annettu");
            }
        }
//        System.out.println("-Asetetaan muuttujat taulukkoon");
        for (char i = 0; i < osat.length; i++) {
            muuttujat.put((char) (i + 'A'), kirjainmuuttujat[i]);
        }
//        System.out.println("-muuttujia on tallennettuna " + muuttujat.size());
    }

    public String getKysymysMuuttujilla() {
        for (char i = 0; i < muuttujienlkm; i++) {
            kysymys = kysymys.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }
        return kysymys;
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

    public String getLaajaVastausMuuttujilla() {
        for (char i = 0; i < muuttujienlkm; i++) {
            laajaVastaus = laajaVastaus.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }
        laajaVastaus = muunnetaanLaajaVastaus();
        return (laajaVastaus.trim());
    }

    public String muunnetaanLaajaVastaus() {
        int alku = 0;
        int loppu = 0;
        for (int i = 0; i < laajaVastaus.length(); i++) {
            if (laajaVastaus.charAt(i) == '{') {
                alku = i;
            }
            if (laajaVastaus.charAt(i) == '}') {
                loppu = i;
            }
            if (loppu != 0) {
//                System.out.println("substring on " + laajaVastaus.substring(alku + 1, loppu));
//                System.out.println("laskettu lasku on " + laskin(laajaVastaus.substring(alku + 1, loppu)));
                this.laajaVastaus = laajaVastaus.replaceFirst("\\{[0-9,\\-,\\*,\\/,\\+,\\.,\\%,\\(,\\)]*\\}",
                        laskin(laajaVastaus.substring(alku + 1, loppu)));
                loppu = 0;
//                System.out.println("muutosten jälkeen laajaVastaus on " + laajaVastaus);
            }
        }
        return laajaVastaus;
    }

    public boolean tarkistaVastaus(String annettuvastaus) {
//        System.out.println("Annettu vastaus on " + annettuvastaus);
//        System.out.println("Oikea vastaus on " + getVastausMuuttujilla());
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

    public String getPisteet() {
        return Integer.toString(oikeatVastaukset);
    }
    
    public String getVastaus() {
        return vastaus;
    }
    
    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }

}
