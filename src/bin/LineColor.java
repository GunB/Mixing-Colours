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
    
    public static ArrayList<LineColor> cloneList(ArrayList<LineColor> list) throws CloneNotSupportedException {
        ArrayList<LineColor> clone = new ArrayList<LineColor>(list.size());
        for (LineColor item : list) {
            clone.add(item.clone());
        }
        return clone;
    }
    
    @Override
    public LineColor clone() throws CloneNotSupportedException{
       return new LineColor(this);
    }
    
    public LineColor(LineColor lnColor){
        this.lstColor = (ArrayList<Color>) lnColor.lstColor.clone();
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
