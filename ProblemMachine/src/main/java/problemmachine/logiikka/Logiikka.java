/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.text.DecimalFormat;
import java.util.HashMap;
import problemmachine.tehtavat.Tehtavat;

/**
 *
 * @author lkaranko
 */
public class Logiikka {

    private Tehtavat tehtava;
    private Satunnaisuus sattuma;
    private Laskin laskija;

    private HashMap<Character, IntVaiDouble> muuttujat;
    private String kysymys;
    private String vastaus;
    private String laajaVastaus;

    private int muuttujienlkm;
    private int oikeatVastaukset;
    private boolean nykyiseenKysymykseenVastattu;

    private DecimalFormat format;

    /**
     * Konstruktorissa annetaan alustetuille muuttujille arvot.
     */
    public Logiikka() {
        format = new DecimalFormat("#.##");
        tehtava = new Tehtavat();
        sattuma = new Satunnaisuus();
        laskija = new Laskin();
        muuttujat = new HashMap<>();
        muuttujienlkm = 0;
        oikeatVastaukset = 0;
        nykyiseenKysymykseenVastattu = false;
    }

    /**
     * Metodi kutsuu tehtävä-luokka-oliota tehtava, jolla ajetaan tämän oman
     * luokan metodi lueTiedosto(). Metodin avulla pystymme logiikasta käsin
     * antamaan tehtävät-luokalle parametrin jolla hakea tiedosto jonka tehtävät
     * ladataan tehtävät-luokan käyttöön.
     *
     * @param nimi String joka sisältää käytettävän tehtävätiedoston nimen.
     *
     * @see problemmachine.tehtavat.Tehtavat#lueTiedosto(String)
     */
    public void kaynnista(String nimi) {
        tehtava.lueTiedosto(nimi);
    }

    /**
     * Metodi hakee Tehtavat-luokasta sattumanvaraisen tehtävän, sekä tämän
     * vastauksen, mallivastauksen ja muuuttujien arvovälit tallennettuna yhteen
     * stringiin. Haettu tehtävä-string annetaan käsiteltäväksi
     * paloitteleTehtava()-metodille, joka erottelee yhdestä stringistä kyseisen
     * tehtävän eri osat. Ennen uuden tehtävän hakemista, annetaan
     * boolean-tyyppiselle muuttujalle nykyiseenKysymykseenVastattu arvoksi
     * epätosi. Tätä käytetään pisteyttämislogiikassa.
     *
     * @see problemmachine.logiikka.Logiikka#tarkistaVastaus(String)
     * @see problemmachine.tehtavat.Tehtavat#valitseSattumanvarainenTehtava()
     */
    public void haeTehtava() {
        nykyiseenKysymykseenVastattu = false;
        paloitteleTehtava(tehtava.valitseSattumanvarainenTehtava());
    }

//    public void haeTehtava(int tehtavanro) {
//        if (tehtavanro + 1 > tehtava.getTehtavienLkmListalla()) {
//            tehtavanro = 0;
//        }
//        vastaus = "$";
//        paloitteleTehtava(tehtava.valitseTehtava(tehtavanro));
//
//    }
    /**
     * Metodissa otetaan parametrina vastaan tehtava-string jossa samassa
     * stringissä on '|'-merkkien jakamina tehtävän eri osat; kysymys, vastaus,
     * mallivastaus ja muuttujien mahdolliset arvot. Käyttämällä split:iä,
     * paloittelemme parametrina saadun stringin ja tallennamme saadut osat
     * omiin luokan private muuttujiin. Viimeinen splitattu osa, joku sisältää
     * kysymyksen muuttujjien arvovälit annetaan edelleen
     * annetaaanSattumanvaraiset()-metodille, jossa tämän arvot käsitellään.
     *
     * @param tehtavaOsat String-jossa tallennettuna tehtävän kaikki osat
     * '|'-merkkien jakamana.
     */
    public void paloitteleTehtava(String tehtavaOsat) {
        System.out.println(tehtavaOsat);
        String[] osat = tehtavaOsat.split("\\|");
//        System.out.println("Tehtavien paloittelussa saatiin " + osat.length + "/4 osaa");
        kysymys = osat[0];
        vastaus = (osat[1]);
        laajaVastaus = osat[2];
        if (!osat[3].trim().isEmpty()) {
            osat = osat[3].split(",");
            muuttujienlkm = osat.length;
            System.out.println("-muuttujienlkm määritelty:" + muuttujienlkm);
            annetaanSattumanvaraiset(osat);
        }

    }

    /**
     * Metodissa arvotaan ja tallenetaan tehtävän satunnaismuuttujat niille
     * tarkoitettuun listaan. Itse arpominen tapahtuu omassa
     * Satunnais-luokassaan, mutta Satunnais-luokkaa kutsutaan tästä metodista.
     * Ensin luodaan IntVaiDouble-tyyppinen lista. IntVaiDouble-luokkatyypin
     * olioihin voidaan tallentaa molempia int ja double tyyppisiä arvoja,
     * jolloin siihen voidaan tallentaa parametrina saadusta arraysta arvot
     * ilman että syntyy konfliktia mikäli arvot ovat int tai double tyyppisiä.
     * Metodin for-loopissa splitataan parametrin stringit (pienempi#-isompi#)
     * kahteen osaan. Antamalla nämä osat annaSattumanvarainenInt tai
     * -Double-luokille parametreinä, saadaan palautteena sattumanvarainen arvo
     * lukujen väliltä (mukaanlukien annetut arvot). Saadut arvot tallennetaan
     * järjestyksessä kirjainmuuttujat hashMappi in, jossa aakkosellisesti
     * kasvavat kirjaimet saavat järjestyksessä tässä arvotut arvot itseilleen.
     *
     * @param osat String, joka sisältää arvovälin jolta arvotaan kirjaimilla
     * esitetyille muuttujille arvot.
     *
     * @see problemmachine.logiikka.Satunnaisuus#annaSattumanvarainenInt(int,
     * int)
     * @see
     * problemmachine.logiikka.Satunnaisuus#annaSattumanvarainenDouble(double,
     * double)
     */
    public void annetaanSattumanvaraiset(String[] osat) {
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
            }
            muuttujat.put((char) (i + 'A'), kirjainmuuttujat[i]);

        }
    }

    /**
     * Metodi palauttaa tehtävän kysymyksen, jossa muuttujat on korvattu niitä
     * vastaavilla numeroilla. Metodi ajaa kirjaimet numeroiksi muuttavan
     * metodin vaihdaArvotMuuttujiin().
     *
     * @return palauttaa tehtävän kysymyksen, jossa muuttujat on korvattu niitä
     * vastaavilla numeroilla.
     */
    public String getKysymysMuuttujilla() {
        return vaihdaArvotMuuttujiin(kysymys);
    }

    /**
     * Metodi vaihtaa saadun stringin muuttujat, eli isot kirjaimet joita
     * edeltää dollarimerkki $ numeroiksi jotka on tallennettu muuttujat
     * hashMappiin.
     *
     * @param vaihdettava String, jossa tekstiä tai laskuja joissa edelleen
     * vielä muuttujat muuttamatta niitä numeroiksi.
     *
     * @return Palauttaa tekstiä jossa dollarimerkein merkatut muuttujat on
     * vaihdettu niitä vastaaviksi numeroiksi.
     *
     * @see problemmachine.logiikka.Logiikka#annetaanSattumanvaraiset(String[])
     */
    public String vaihdaArvotMuuttujiin(String vaihdettava) {
        for (char i = 0; i < muuttujienlkm; i++) {
            vaihdettava = vaihdettava.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }
        return vaihdettava;
    }

    /**
     * Metodi palauttaa tehtävän vastauksen, jossa vastauksen muuttujien tilalle
     * on asetettu muuttujat-hashMap:in niille asetetut arvot. Mikäli
     * vastauksessa on laskuja, ne lasketaan ennen palautusta. Metodi tarkistaa
     * onko stringissä muuttujia, jos siinä ei ole, ei tarvita toimenpiteitä.
     *
     * @return Palautetaan vastaus, jossa dollarimerkein edeltävät isot
     * kirjaimet on vaihdettu niitä vastaaviksi numeroiksi ja laskut on
     * laskettu.
     */
    public String getVastausMuuttujilla() {
        if (vastaus == null) {
            return "Tälle tehtävälle ei ole vastausta";
        }
        if (!vastaus.contains("$")) {
            return vastaus;
        }
        format.setDecimalSeparatorAlwaysShown(false);
        vastaus = lasketaanVastaukset(vaihdaArvotMuuttujiin(vastaus));
//        System.out.println(vastaus);
        return vastaus;
    }

    /**
     * Metodi palauttaa tehtävän mallivastauksen, jossa mallivastauksen
     * muuttujien tilalle on asetettu muuttujat-hashMap:in niille asetetut arvot
     * ja mallivastauksessa olevat laskut jotka on ympäröitä {}-merkeillä on
     * laskettu. Metodi tarkistaa onko stringissä muuttujia, jos siinä ei ole,
     * ei tarvita toimenpiteitä.
     *
     * @return Palautetaan mallivastaus, jossa dollarimerkein edeltävät isot
     * kirjaimet on vaihdettu niitä vastaaviksi numeroiksi ja laskut on
     * laskettu.
     */
    public String getLaajaVastausMuuttujilla() {
        if (laajaVastaus == null) {
            return "Tälle tehtävälle ei ole mallivastausta";
        }
        laajaVastaus = lasketaanVastaukset(vaihdaArvotMuuttujiin(laajaVastaus));
        this.laajaVastaus = laajaVastaus.trim();
        return (laajaVastaus);
    }

    /**
     * Metodi saa stringin, jossa on laskemattomia laskuja. Laskut, joita
     * ympäröivät kaarisulut lasketaan ja niiden tulokset asetetaan
     * kaarisulkujen ja niitä sisältävien laskujen tilalle. Laskutoimitukset
     * tapahtuvat Laskin-luokassa. Käyttämällä regex-merkintää, pystymme
     * vaihtamaan laskujen tilalle saamamme arvot. Metodi käy läpi jokaisen
     * parametrissä saamansa merkin yksi kerrallaan. Kun metodi on löytänyt
     * sulkevan kaarisulun, vaihtaa tämä kaarisulkujen sisällön laskettuun
     * laskuun.
     *
     * @param syote String, jossa on laskuja jotka tulee laskea. Laskettavat
     * laskut on merkitty {}-aaltosuluilla. Niiden sisältämät laskut lasketaan.
     *
     * @return Palautteena on aluksi parametrina saatu string, jossa kaikki
     * kaarisuluin ympäröidyt laskut on laskettu ja niiden tulokset on asetettu
     * kyseisten laskujen tilalle.
     */
    public String lasketaanVastaukset(String syote) {
        int alku = 0;
        int loppu = 0;
        for (int i = 0; i < syote.length(); i++) {
            if (syote.charAt(i) == '{') {
                alku = i;
            }
            if (syote.charAt(i) == '}') {
                loppu = i;
            }
            if (loppu != 0) {
//                System.out.println("substring on " + laajaVastaus.substring(alku + 1, loppu));
//                System.out.println("laskettu lasku on " + laskija.laskin(laajaVastaus.substring(alku + 1, loppu)));
                syote = syote.replaceFirst("\\{[0-9,\\-,\\*,\\/,\\+,\\.,\\%,\\(,\\)]*\\}",
                        laskija.laskin(syote.substring(alku + 1, loppu)));
                loppu = 0;
//                System.out.println("muutosten jälkeen laajaVastaus on " + laajaVastaus);
            }
        }
        return syote;
    }

    /**
     * Metodi tarkistaa annetun vastauksen numeerisen arvon. Annetusta
     * vastauksesta ja esimerkistä poistetaan muut kuin numerot.
     *
     * @param annettuvastaus tätä verrataan ohjelman antamaan vastaukseen.
     * @return true/false, onko vastaus oikein.
     */
    public boolean tarkistaVastaus(String annettuvastaus) {
//        System.out.println("Annettu vastaus on " + annettuvastaus);
//        System.out.println("Ohjelmaan tallennettu vastaus on " + getVastausMuuttujilla());
//        System.out.println("Oikea vastaus on " + getVastausMuuttujilla().replaceAll("[[a-zA-ZäöåÄÖÅ ]]", "").trim());
        String vastausTrim = annettuvastaus.trim().replaceAll("[[a-zA-ZäöåÄÖÅ ]]", "");
        if (vastausTrim.equals(getVastausMuuttujilla().replaceAll("[[a-zA-ZäöåÄÖÅ ]]", "").trim())) {
            if (!nykyiseenKysymykseenVastattu) {
                oikeatVastaukset++;
            }
            nykyiseenKysymykseenVastattu = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa saatujen pisteiden määrän.
     *
     * @return palaute on käyttäjän saamat pisteet.
     */
    public String getPisteet() {
        return Integer.toString(oikeatVastaukset);
    }

    public Tehtavat getTehtavat() {
        return tehtava;
    }

}
