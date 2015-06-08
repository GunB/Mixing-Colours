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
    String strColor1;
    String strColor2;
    String strColorR;

    public Rule(String strColor1, String strColor2, String strColorR) {
        this.strColor1 = strColor1;
        this.strColor2 = strColor2;
        this.strColorR = strColorR;
    }

    public String getStrColor1() {
        return strColor1;
    }

    public void setStrColor1(String strColor1) {
        this.strColor1 = strColor1;
    }

    public String getStrColor2() {
        return strColor2;
    }

    public void setStrColor2(String strColor2) {
        this.strColor2 = strColor2;
    }

    public String getStrColorR() {
        return strColorR;
    }

    public void setStrColorR(String strColorR) {
        this.strColorR = strColorR;
    }
    
    
}
