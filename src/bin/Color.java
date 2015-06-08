/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

/**
 *
 * @author GunBlade
 */
public class Color {

    public String strColor;
    public float ftProbabilidad;
    public boolean bulFlagCombine;

    public Color(String strColor, float ftProbabilidad) {
        this.strColor = strColor;
        this.ftProbabilidad = ftProbabilidad;
    }

    public Color(String strColor) {
        this.strColor = strColor;
    }

}
