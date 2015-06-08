/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mixing;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new Mixing().Run();
        } catch (IOException ex) {
            Logger.getLogger(Mixing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Run() throws IOException {
        File file = FileUtils.Read(FileUtils.strRoot + File.separator + "1.in");

        boolean isRuled = false;
        int contRules = -1;
        int contCases = -1;
        int contRulesCase = -1;
        ArrayList<Rule> lstRules = new ArrayList<>();
        

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
            
            if(isRuled && contRules == 0 && contCases < 0){
                contCases = Integer.parseInt(line);
                continue;
            }
            
            if(contCases > 0){
                
            }
        }
    }

}
