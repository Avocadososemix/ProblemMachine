/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine;

import problemmachine.logiikka.Logiikka;
import problemmachine.tehtavat.Tehtavat;
import problemmachine.ui.Kayttoliittyma;

/**
 *
 * @author lkaranko
 */
public class Main {

    /**
     * Luodaan ja käynnistetään käyttöliittymä.
     * 
     * @param args Ohjelman-komentorivi-argumentit.
     */
    public static void main(String[] args) {

        Logiikka logic = new Logiikka();
        Kayttoliittyma kayttis = new Kayttoliittyma(logic);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                kayttis.setVisible(true);
            }
        });

    }
}
