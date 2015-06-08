/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mixing;

import bin.Case;
import bin.Color;
import bin.LineColor;
import bin.Rule;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FileUtils;

/**
 *
 * @author hangarita
 */
public class Mixing {

    boolean isRuled = false;
    int contRules = -1;
    int contCases = -1;
    int contRulesCase = 0;
    ArrayList<Rule> lstRules = new ArrayList<>();

    ArrayList<Case> lstCases = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Mixing mix = new Mixing().Run();
            mix.Play();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Mixing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Play(){
        
    }
    
    public ArrayList TestCase(Case datCase){
        ArrayList<LineColor> lnColors = new ArrayList<>();
        
        
        
        return lnColors;
    }

    private Mixing Run() throws IOException {
        File file = FileUtils.Read(FileUtils.strRoot + File.separator + "1.in");
        Case tempCase = null;

        for (String line : Files.readAllLines(file.toPath())) {
            //System.out.println(line);
            if (contRules < 0 && !isRuled) {
                contRules = Integer.parseInt(line);
                isRuled = true;
                continue;
            }

            if (isRuled && contRules > 0) {
                String[] split = line.split("\\s+");
                lstRules.add(new Rule(split[0], split[1], split[2]));
                contRules--;
                continue;
            }

            if (isRuled && contRules == 0 && contCases < 0) {
                contCases = Integer.parseInt(line);
                continue;
            }

            if (contCases > 0 && contRulesCase == 0) {
                contRulesCase = Integer.parseInt(line);
                tempCase = new Case();
                continue;
            }

            if (contRulesCase > 0) {
                String[] split = line.split("\\s+");
                ArrayList<Color> lstColors = new ArrayList<>();
                for (int i = 0; i < split.length; i = i + 2) {
                    Color color = new Color(split[i], Float.parseFloat(split[i+1]));
                    lstColors.add(color);
                    if(split[i+2].contains("END")){
                        break;
                    }
                }
                LineColor lnColor = new LineColor(lstColors);
                tempCase.lstColors.add(lnColor);
                
                contRulesCase--;
                if(contRulesCase == 0){
                    lstCases.add(tempCase);
                    System.out.println(tempCase.PrintCase());
                }
            }
        }
        return this;
    }

}
