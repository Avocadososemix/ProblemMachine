/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.util.Random;
import problemmachine.tehtavat.Tehtavat;

/**
 *
 * @author lkaranko
 */
public class Logiikka {

    Tehtavat tehtava = new Tehtavat();
    String nykyinenTehtava;

    //tässä säilytettynä ohjelmassa esiintyvät muuttujat. Tätä pitää vielä hiota.
    private double A;
    private double B;
    private double C;

    private String kysymys;
    private int vastaus;
    private String laajaVastaus;

    public Logiikka() {

    }

    public void haeTehtava() {
        paloitteleTehtava(tehtava.valitseSattumanvarainenTehtava());
//        nykyinenTehtava = matematiikka.valitseSattumanvarainenTehtava();
//        System.out.println(nykyinenTehtava);
    }

    public void haeTehtava(int tehtavanro) {
        paloitteleTehtava(tehtava.valitseTehtava(tehtavanro));

    }

    //osa 1 = tehtävä; osa 2 = vastaus; osa 3 = tehtävä avattuna; osa 4 = vaikeusaste/aihealue.
    //pitäisiköhän tässä tallentaa osat yleisiin muuttujiin?
    //tehtavan alkuun kaikki muuttujat? tai loppuun?
    public void paloitteleTehtava(String tehtavaOsat) {
        String[] osat = tehtavaOsat.split("||");
        kysymys = osat[0];
        vastaus = Integer.parseInt(osat[1]);
        laajaVastaus = osat[2];

        osat = osat[3].split(",");
        int[] muuttujat = new int[osat.length];
        for (int i = 0; i < osat.length; i++) {
            String[] minmax = osat[i].split("-");
            muuttujat[i] = annaSattumanvarainenInt(Integer.parseInt(minmax[0]), Integer.parseInt(minmax[1]));

        }
        //säädä vielä
        A = muuttujat[0];
        B = muuttujat[1];
        C = muuttujat[2];
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    public int annaSattumanvarainenInt(int min, int max) {
        int randomLuku = min + (int) (Math.random() * ((max - min) + 1));
        return randomLuku;
    }

    /**
     *
     * @param annettuvastaus
     * @return
     */
    public boolean tarkistaVastaus(String annettuvastaus) {
        int vastausInt = Integer.parseInt(annettuvastaus);
        return vastausInt == vastaus;
    }

}
