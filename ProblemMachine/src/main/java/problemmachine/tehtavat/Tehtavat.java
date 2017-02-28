/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.tehtavat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lkaranko
 */
public class Tehtavat {

    private List<String> tehtavalista = new ArrayList();
    private List<Integer> tehdytTehtavat = new ArrayList();
    private Random r;

    /**
     * Konstruktori saa parametrinään random tyyppisen muuttujan, jonka arvo
     * tallenetaan testaamista varten Remembering Random luokkaan. Tätä
     * konstruktoria käytetään vain luokan junit-testaamisessa.
     *
     * @param r On random olio jonja arvo tallennetaan ennen kuin se annetaan
     * konstruktorille, jotta voidaan tarkastella sattumanvaraisuutta
     * hyödyntäviä metodeja.
     *
     *
     */
    public Tehtavat(Random r) {
        this.r = r;
    }

    /**
     * Konstruktori luo uuden Random-tyyppisen olion kun luokka ajetaan
     * ensimmäistä kertaa.
     */
    public Tehtavat() {
        this(new Random());
    }

    /**
     * Metodi saa parametrinaan String-tyyppisenä luettavan tekstitiedoston
     * nimen, jonka avulla voi metodi lukea tiedoston rivit ja tallentaa ne
     * tehtavalista-listaan. Metodin ajaminen tyhjentää myös aiemmin täytetyt
     * tehtävlistat ja tehtyjenTehtävien listat, sillä tämä metodi ajetaan kun
     * ladataan uusi sarja tehtäviä. Tällöin uudet tehtävät eivät päädy samalle
     * listalle, jolloin tehtäviä hakiessa saamme vain uudesta tiedostosta
     * peräisin olevia tehtäviä.
     *
     * @param lahdetiedosto Tiedoston nimi joka luetaan.
     */
    public void lueTiedosto(String lahdetiedosto) {
        tehtavalista.clear();
        tehdytTehtavat.clear();
        InputStream inputti = getClass().getResourceAsStream(lahdetiedosto);
        Scanner lukija = new Scanner(inputti);
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            tehtavalista.add(rivi);
        }

    }

    /**
     * Metodi palauttaa sattumanvaraisen rivin tehtavalista-listalta. Tämä
     * arvotaan käyttämällä samassa luokassa olevaa
     * valitseSattumanvarainenPainotettu-metodia käyttäen.
     *
     * @return Palautetaan String tyyppinen teksti, jossa on tallennettuna yksi
     * rivi lueTiedosto()-metodissa valitusta ja listaan tallennetusta
     * tiedostosta. Rivi sisältää kysymyksen, vastauksen, mallivastauksen ja
     * tehtävän muuttujien arvovälit.
     */
    public String valitseSattumanvarainenTehtava() {
//        System.out.println("Valitaan satunnainen tehtävä");
        return tehtavalista.get(valitseSattumanvarainenPainotettu(tehtavalista.size()));
    }

    /**
     * Metodi palauttaa tietyn valitsemamme tehtävän tehtävälistalta.
     *
     * @param tehtavanro Parametri antaa sen tehtävälistan indeksin arvon jota
     * vastaavan rivin haluamme palauttaa.
     *
     * @return Palautetaan String tyyppinen teksti, jossa on tallennettuna yksi
     * rivi lueTiedosto()-metodissa valitusta ja listaan tallennetusta
     * tiedostosta. Rivi sisältää kysymyksen, vastauksen, mallivastauksen ja
     * tehtävän muuttujien arvovälit. Olemme valinneet rivin listalta
     * käyttämällä paratmerista saatua arvoa.
     */
    public String valitseTehtava(int tehtavanro) {
//        System.out.println("Valitaan tehtävä " + tehtavanro);
        return tehtavalista.get(tehtavanro);
    }

    /**
     * Metodi palauttaa sattumanvaraisen luvun nollan ja saadun parametrin
     * väliltä. Mikäli käyttäjä on jo tehnyt kyseisen tehtävän, arvotaan
     * tehtävänumero uudestaan. Täten palautettavat numerot ovat painotettu
     * hieman tekemättömien tehtävien suuntaan.
     *
     * @param max Integer, max on tehtävälistan koko ja tämän arvoa käytetään
     * kun valitaan jokin arvo nollan ja koon väliltä.
     *
     * @return Palaute on painotettu sattumanvarainen arvo nollan ja max:in
     * väliltä.
     */
    public int valitseSattumanvarainenPainotettu(int max) {
//        System.out.println("Arvotaan luku satunnaisen tehävän valitsemista varten. Int max on " + max);
        int randomLuku = r.nextInt(max);
        if (tehdytTehtavat.contains(randomLuku) && tehdytTehtavat.size() != tehtavalista.size()) {
            //tässä pienennetään todennäköisyyttä että saadaan uudestaan jo tehty tehtävä.
            //Kun kaikki tehtävät on jo tehty, tätä iffiä ei sovelleta enää.
            randomLuku = r.nextInt(max);
        }
        return randomLuku;
    }

    /**
     * Metodi palauttaa tehtavalistan pituuden.
     *
     * @return Palate on int-tyyppinen muuttuja, josta ilmenee tehtävälistan
     * pituus.
     */
    public int getTehtavienLkmListalla() {
        return tehtavalista.size();
    }

}
