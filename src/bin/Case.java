/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.ArrayList;

/**
 *
 * @author GunBlade
 */
public class Case {

    public float dubPeso;

    public ArrayList<LineColor> lstColors = new ArrayList<>();
    
    public String PrintCase(){
        String strData = "";
        
        for(LineColor line : lstColors){
            strData += "\n";
            for(Color color : line.lstColor){
                strData += " C:" + color.strColor + " P:" + color.ftProbabilidad;
                strData += " -";
            }
        }
        
        return strData;
    }
}
