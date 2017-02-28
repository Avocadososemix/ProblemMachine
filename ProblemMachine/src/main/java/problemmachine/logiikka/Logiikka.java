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

    public void kaynnista(String nimi) {
        tehtava.lueTiedosto(nimi);
    }

    public void haeTehtava() {
        vastaus = "$"; //onko tarpeen?
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
    
    //osa 1 = tehtävä; osa 2 = vastaus; osa 3 = tehtävä avattuna; osa 4 = muuttujien arvot.
    private void paloitteleTehtava(String tehtavaOsat) {
        System.out.println(tehtavaOsat);
        String[] osat = tehtavaOsat.split("\\|");
        System.out.println("Tehtavien paloittelussa saatiin " + osat.length +"/4 osaa");
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

    private void annetaanSattumanvaraiset(String[] osat) {
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

    public String getKysymysMuuttujilla() {
        return vaihdaArvotMuuttujiin(kysymys);
    }

    private String vaihdaArvotMuuttujiin(String vaihdettava) {
        for (char i = 0; i < muuttujienlkm; i++) {
            vaihdettava = vaihdettava.replace("$" + (char) ('A' + i), muuttujat.get((char) ('A' + i)).toString());
        }
        return vaihdettava;
    }

    public String getVastausMuuttujilla() {
        if (!vastaus.contains("$")) {
            return vastaus;
        }
        format.setDecimalSeparatorAlwaysShown(false);
        vastaus = lasketaanVastaukset(vaihdaArvotMuuttujiin(vastaus));
//        System.out.println(vastaus);
        return vastaus;
    }

    public String getLaajaVastausMuuttujilla() {
        laajaVastaus = lasketaanVastaukset(vaihdaArvotMuuttujiin(laajaVastaus));
        this.laajaVastaus = laajaVastaus.trim();
        return (laajaVastaus);
    }

    private String lasketaanVastaukset(String syote) {
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

    public String getPisteet() {
        return Integer.toString(oikeatVastaukset);
    }

}
