/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine;

import problemmachine.logiikka.Logiikka;
import problemmachine.tehtavat.Tehtavat;

/**
 *
 * @author lkaranko
 */
public class Main {

    public static void main(String[] args) {

        Tehtavat matsku = new Tehtavat();
        Logiikka logic = new Logiikka();
        
        matsku.lueTiedosto();
        logic.haeTehtava();

    }

}
