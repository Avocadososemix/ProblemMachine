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

    /**
     * Konstruktori joka antaa arvoInt:lle arvon, sekä muuttaa boolean kumpi:n
     * todeksi. Saatu arvo tallennetaan yleiseen muuttujaan.
     *
     * @param arvo, Integer, parametrin tyyppi määrittelee kumpi-muuttujan
     * totisuuden.
     */
    public IntVaiDouble(int arvo) {
        this.arvoInt = arvo;
        kumpi = true;
    }

    /**
     * Konstruktori joka antaa arvoDouble:lle arvon, sekä muuttaa boolean
     * kumpi:n epätodeksi. Saatu arvo tallennetaan yleiseen muuttujaan.
     *
     * @param arvo, Double, parametrin tyyppi määrittelee kumpi-muuttujan
     * totisuuden.
     */
    public IntVaiDouble(double arvo) {
        this.arvoDouble = arvo;
        kumpi = false;
    }

    /**
     * Metodi tarkistaa onko luokan saama arvo int-tyyppiä.
     *
     * @return palautetaan true jos saatu arvo on int-tyyppinen, false mikäli
     * arvo on double-tyyppiä.
     */
    public boolean testOnkoInt() {
        return kumpi;
    }

    /**
     * Palauttaa int-tyyppisen arvon luokasta mikäli sellainen on sinne
     * tallennettu.
     *
     * @return palautus on arvoInt, int-tyyppinen muuttuja.
     */
    public int getIntArvo() {
        return arvoInt;
    }

    /**
     * Palauttaa double-tyyppisen arvon luokasta mikäli sellainen on sinne
     * tallennettu.
     *
     * @return palautus on arvoDouble, double-tyyppinen muuttuja.
     */
    public double getDoubleArvo() {
        return arvoDouble;
    }

    /**
     * Metodi antaa String-tyyppisenä arvon joka on tallennettuna
     * IntVaiDouble-luokkaan.
     *
     * @return palautetaan String-tyyppisenä IntVaiDoublen arvo.
     */
    @Override
    public String toString() {
        if (kumpi) {
            return Integer.toString(arvoInt);
        } else {
            return Double.toString(arvoDouble);
        }

    }

}
