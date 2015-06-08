/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author GunBlade
 */
public class Case {

    public Float dubPeso;

    public ArrayList<LineColor> lstColors = new ArrayList<>();
    public ArrayList<Case> lstCases = new ArrayList<>();
    
    public Case(){
        
    }
    
    public Case(Case datCase){
        this.dubPeso = datCase.dubPeso;
        this.lstColors = (ArrayList<LineColor>) datCase.lstColors.clone();
        this.lstCases = (ArrayList<Case>) datCase.lstCases.clone();
        
        //this = (Case) datCase.clone();
    }

    public String PrintCase() {
        String strData = "";

        for (LineColor line : lstColors) {
            strData += "\n";
            for (Color color : line.lstColor) {
                strData += " C:" + color.strColor + " P:" + color.ftProbabilidad + " F:" + color.bulFlagCombine;
                strData += " -";
            }
        }

        return strData;
    }

    public void CleanCase() {
        for (LineColor line : lstColors) {

            ArrayList<Color> lstColors = line.lstColor;
            Iterator<Color> i = lstColors.iterator();

            while (i.hasNext()) {
                Color color = i.next(); // must be called before you can call i.remove()
                // Do something
                if (color.bulFlagCombine) {
                    color.bulFlagCombine = false;
                } else {
                    i.remove();
                }

            }
        }
    }
    
    public int counThings(){
        int contColors = 0;
        for (LineColor line : lstColors) {
            for(Color color : line.lstColor){
                contColors++;
            }
        }
        
        return contColors;
    }
}
