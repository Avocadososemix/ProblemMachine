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

    public static void main(String[] args) {

        Logiikka logic = new Logiikka();
        Kayttoliittyma kayttis = new Kayttoliittyma(logic);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                kayttis.setVisible(true);
            }
        });

//        System.out.println("Uusi logiikka luotu");
        //kysymyksetMatematiikka.txt
        //kysymyksetFysiikka.txt
        //kysymyksetKemia.txt
//        System.out.println("Kysymykset ladattu");
//        
//        logic.kaynnista("kysymyksetMatematiikka.txt");
//        logic.haeTehtava();
//        System.out.println(logic.getKysymysMuuttujilla());
//        System.out.println(logic.getVastausMuuttujilla());
//        System.out.println("Laajavastaus");
//System.out.println("moi!");
//        System.out.println(logic.getLaajaVastausMuuttujilla());
//
//    }
    }
}
