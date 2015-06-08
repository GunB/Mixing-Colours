/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

/**
 *
 * @author hangarita
 */
public class Rule {
    Color strColor1;
    Color strColor2;
    Color strColorR;
//<editor-fold defaultstate="collapsed" desc="Constructor">

    public Rule(Color strColor1, Color strColor2, Color strColorR) {
        this.strColor1 = strColor1;
        this.strColor2 = strColor2;
        this.strColorR = strColorR;
    }
    
//</editor-fold>
    
    private boolean isColorAdd(Color color){
        if(color.strColor.equals(strColor1.strColor)){
            return true;
        }else if(color.strColor.equals(strColor2.strColor)){
            return true;
        }
        return false;
    }
    
    public boolean isMixable(Color color1, Color color2){
        return isColorAdd(color1) && isColorAdd(color2);
    }
    
    public Color Mix(Color color1, Color color2){
        if(isMixable(color1, color2)){
            Color newColor = new Color(strColorR.strColor, color1.ftProbabilidad * color2.ftProbabilidad);
            return newColor;
        }
        return null;
    }
    
}
