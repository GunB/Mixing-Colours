/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author GunBlade
 */
public class Case {

    public Float dubPeso;

    public ArrayList<LineColor> lstLineColors = new ArrayList<>();
    public ArrayList<Case> lstCases = new ArrayList<>();
    
    public Case(){
        
    }
    
    public Case(Case datCase){
        this.dubPeso = datCase.dubPeso;
        this.lstLineColors = (ArrayList<LineColor>) datCase.lstLineColors.clone();
        this.lstCases = (ArrayList<Case>) datCase.lstCases.clone();
        
        //this = (Case) datCase.clone();
    }
    
    public boolean haveColors(ArrayList<Color> lstColors){
        
        if(lstColors.size() == lstLineColors.size()){
            
            for(int i =0; i<lstColors.size(); i++){
                if(!lstLineColors.get(i).HaveColors(lstColors.get(i))){
                    return false;
                }
            }
            return true;
            
        }else{
            return false;
        }
    }

    public String PrintCase() {
        String strData = "";

        for (LineColor line : lstLineColors) {
            strData += "\n";
            for (Color color : line.lstColor) {
                strData += " C:" + color.strColor + " P:" + color.ftProbabilidad + " F:" + color.bulFlagCombine;
                strData += " -";
            }
        }

        return strData;
    }

    public void CleanCase() {
        for (LineColor line : lstLineColors) {

            ArrayList<Color> lstLineColors = line.lstColor;
            Iterator<Color> i = lstLineColors.iterator();

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
    
    public boolean emptyLine(){
        
        for (LineColor line : lstLineColors) {
            if(line.lstColor.isEmpty()){
                return true;
            }
        }
        
        return false;
    }
    
    public int counThings(){
        int contColors = 0;
        for (LineColor line : lstLineColors) {
            for(Color color : line.lstColor){
                contColors++;
            }
        }
        
        return contColors;
    }
}
