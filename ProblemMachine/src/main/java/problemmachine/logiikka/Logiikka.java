/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import problemmachine.matematiikka.Matikka;

/**
 *
 * @author lkaranko
 */
public class Logiikka {

    Matikka matematiikka = new Matikka();
    String nykyinenTehtava;

    //tässä säilytettynä ohjelmassa esiintyvät muuttujat. Tätä pitää vielä hiota.
    double Ad;
    double Bd;
    double Cd;

    public Logiikka() {

    }

    public void haeMatiikka() {
        matematiikka.lueTiedosto();
        nykyinenTehtava = matematiikka.valitseSattumanvarainenTehtava();
        System.out.println(nykyinenTehtava);
    }

    public void haeMatiikka(int tehtavanro) {

    }

    public void haeFyssa() {

    }

    public void haeFyssa(int tehtavanro) {

    }

    //osa 1 = tehtävä; osa 2 = vastaus; osa 3 = tehtävä avattuna; osa 4 = vaikeusaste/aihealue.
    //pitäisiköhän tässä tallentaa osat yleisiin muuttujiin?
    //tehtavan alkuun kaikki muuttujat? tai loppuun?
    public String[] paloitteleTehtava(String tehtavaOsat) {
        String[] osat = tehtavaOsat.split("||");
        return osat;
    }
}
