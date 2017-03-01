/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.tehtavat;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lkaranko
 */
public class RememberingRandom extends Random {

    private ArrayList<Double> doubleRandom;
    private ArrayList<Integer> intRandom;

    /**
     *
     */
    public RememberingRandom() {
        doubleRandom = new ArrayList<Double>();
        intRandom = new ArrayList<Integer>();
    }

    @Override
    public int nextInt(int bound) {
//        int lukuInt = super.nextInt(bound);
        int lukuInt = bound;
        intRandom.add(lukuInt);
        return lukuInt;
    }

    @Override
    public double nextDouble() {
        double lukuDouble = super.nextDouble();
        doubleRandom.add(lukuDouble);
        return lukuDouble;
    }

    /**
     *
     * @return
     */
    public ArrayList<Double> getDoubleRandom() {
        return doubleRandom;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getIntRandom() {
        return intRandom;
    }

}
