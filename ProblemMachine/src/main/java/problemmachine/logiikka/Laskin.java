/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemmachine.logiikka;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author lkaranko
 */
public class Laskin {

    DecimalFormat format;

    public Laskin() {
        format = new DecimalFormat("#.##");
    }

    public String laskin(String input) {
        format.setDecimalSeparatorAlwaysShown(false);
        format.setRoundingMode(RoundingMode.CEILING);
        try {
            ScriptEngineManager manageri = new ScriptEngineManager();
            ScriptEngine engine = manageri.getEngineByName("JavaScript");
            String palaute = engine.eval(input).toString();
            if (palaute.contains(".")) {
                input = format.format(Double.parseDouble(palaute));
                return input;
            } else {
                input = palaute;
                return input;
            }
        } catch (ScriptException | NumberFormatException e) {
            System.out.println(e);
        }
        return "";
    }

}
