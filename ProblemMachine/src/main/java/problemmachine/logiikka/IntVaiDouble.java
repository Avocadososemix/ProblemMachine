/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

/**
 *
 * @author lkaranko
 */
public class IntVaiDouble {

    private int arvoInt;
    private double arvoDouble;
    boolean kumpi;

    public IntVaiDouble(int arvo) {
        this.arvoInt = arvo;
        kumpi = true;
    }

    public IntVaiDouble(double arvo) {
        this.arvoDouble = arvo;
        kumpi = false;
    }

    public boolean testOnkoInt() {
        return kumpi;
    }

    public int testIntSeOn() {
        return arvoInt;
    }

    public double testDoubleSeOn() {
        return arvoDouble;
    }

    @Override
    public String toString() {
        if (kumpi) {
            return Integer.toString(arvoInt);
        } else {
            return Double.toString(arvoDouble);
        }

    }

}
