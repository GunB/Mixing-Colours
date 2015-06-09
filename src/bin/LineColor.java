/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author GunBlade
 */
public class LineColor {
    public ArrayList<Color> lstColor = new ArrayList<>();

    public LineColor(ArrayList lstColor) {
        this.lstColor = lstColor;
    }
    
    public LineColor(Color[] colors){
        this.lstColor = new ArrayList<>(Arrays.asList(colors));
    }
    
    public boolean HaveColors(Color color){
        for(Color color2 : lstColor){
            if(color.strColor.equals(color2.strColor)){
                return true;
            }
        }
        return false;
    }
    
    public LineColor(Color color){
        Color[] colors = new Color[1];
        colors[0] = color;
        this.lstColor = new ArrayList<>(Arrays.asList(colors));
    }
    
}
