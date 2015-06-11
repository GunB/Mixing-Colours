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
import java.util.Scanner;
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

    public void Play() {
        /*ArrayList<Case> TestCase = TestCase(lstCases.get(1), 0, -1);
        
         for (Case tempCase : TestCase) {
         System.out.println(tempCase.PrintCase());
         }*/

        for (Case tempCase : lstCases) {
            ArrayList<Case> testCase = TestCase(tempCase, 0, -1);

            if (testCase == null) {
                System.out.println("GAMEOVER");
            } else {
                Case WinCase = WinCase(testCase);
                System.out.println(WinCase.PrintCase2());
            }

        }
    }

    private Case WinCase(ArrayList<Case> lstCases) {
        Case winCase = lstCases.get(0);

        for (int i = 1; i < lstCases.size(); i++) {
            if (winCase.lstLineColors.get(0).lstColor.get(0).ftProbabilidad
                    < lstCases.get(i).lstLineColors.get(0).lstColor.get(0).ftProbabilidad) {
                winCase = lstCases.get(i);
            }
        }

        return winCase;
    }

    private ArrayList<Case> TestCase(Case datCase, int intLevel, int intCase) {
        ArrayList<Case> lstNewCases = new ArrayList<>();

        Case tempTestCase = new Case(datCase);

        datCase = CleanCase(datCase);
        int counThings = datCase.counThings();

        boolean emptyLine = datCase.emptyLine();

        if (emptyLine) {
            return null;
        }

        if (counThings == 1) {
            datCase.lstCases = null;
            lstNewCases.add(datCase);
            return lstNewCases;
        } else if (counThings == 0) {
            return null;
        }

        //<editor-fold defaultstate="collapsed" desc="Creating cases lstNewCases.add(tempCase)">
        for (int i = 0; i < datCase.lstLineColors.size() - 1; i++) {
            LineColor lnColors1 = datCase.lstLineColors.get(i);
            LineColor lnColors2 = datCase.lstLineColors.get(i + 1);

            for (Color color1 : lnColors1.lstColor) {
                for (Color color2 : lnColors2.lstColor) {

                    Color newColor = Mixable(color1, color2);

                    if (newColor != null) {
                        Object objCase = (Object) datCase;

                        Case tempCase = new Case(datCase);//datCase;
                        //SerializationUtils.clone(datCase);

                        tempCase.lstLineColors.remove(i);
                        tempCase.lstLineColors.remove(i);
                        tempCase.lstLineColors.add(i, new LineColor(newColor));

                        lstNewCases.add(tempCase);

                        //datCase.lstCases.add(tempCase);
                        //System.out.println(tempCase.PrintCase());
                    }

                }
            }
        }
        //</editor-fold>

        if (lstNewCases.isEmpty()) {
            return null;
        } else {
            ArrayList<Case> lstTempCases = new ArrayList<>();
            int cont = 0;
            for (Case tempCaseNew : lstNewCases) {
                ArrayList<Case> TestCase = TestCase(tempCaseNew, intLevel + 1, cont);
                if (TestCase != null && !TestCase.isEmpty()) {
                    lstTempCases.addAll(TestCase);
                }
                cont++;
            }
            return lstTempCases;
        }
    }

    private Case CleanCase(Case datCase) {
        int counThings = datCase.counThings();

        if (counThings == 1) {
            return datCase;
        } else if (counThings == 0) {
            return null;
        }

        for (int i = 0; i < datCase.lstLineColors.size() - 1; i++) {
            LineColor lnColors1 = datCase.lstLineColors.get(i);
            LineColor lnColors2 = datCase.lstLineColors.get(i + 1);

            for (Color color1 : lnColors1.lstColor) {
                for (Color color2 : lnColors2.lstColor) {
                    if (Mixable(color1, color2) != null) {
                        color1.bulFlagCombine = true;
                        color2.bulFlagCombine = true;
                    }
                }
            }
        }
        datCase.CleanCase();
        return datCase;
    }

    private Color Mixable(Color color1, Color color2) {
        boolean isMixable;
        for (Rule rule : lstRules) {
            isMixable = rule.isMixable(color1, color2);
            if (isMixable) {
                return rule.Mix(color1, color2);
            }
        }

        return null;
    }

    /*
    Leyendo los datos desde Consola
    */
    private Mixing Runnable() {
        Scanner scanIn = new Scanner(System.in);
        contRules = Integer.parseInt(scanIn.nextLine());

        while (contRules > 0) {
            String line = scanIn.nextLine();
            String[] split = line.split("\\s+");
            lstRules.add(new Rule(new Color(split[0]), new Color(split[1]), new Color(split[2])));
            contRules--;
        }
        
        contCases = Integer.parseInt(scanIn.nextLine());
        
        while(contCases > 0){
            contRulesCase = Integer.parseInt(scanIn.nextLine());
            Case tempCase = new Case();
            
            while(contRulesCase > 0){
                String line = scanIn.nextLine();
                
                String[] split = line.split("\\s+");
                ArrayList<Color> lstLineColors = new ArrayList<>();
                for (int i = 0; i < split.length; i = i + 2) {
                    Color color = new Color(split[i], Float.parseFloat(split[i + 1]));
                    lstLineColors.add(color);
                    if (split[i + 2].contains("END")) {
                        break;
                    }
                }
                LineColor lnColor = new LineColor(lstLineColors);
                tempCase.lstLineColors.add(lnColor);
                
                contRulesCase--;
            }
            lstCases.add(tempCase);
            contCases--;
        }
        
        scanIn.close();
        return this;
    }

    /*
    Leyendo los datos desde el archivo de texto "1.in"
    */
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
                lstRules.add(new Rule(new Color(split[0]), new Color(split[1]), new Color(split[2])));
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
                ArrayList<Color> lstLineColors = new ArrayList<>();
                for (int i = 0; i < split.length; i = i + 2) {
                    Color color = new Color(split[i], Float.parseFloat(split[i + 1]));
                    lstLineColors.add(color);
                    if (split[i + 2].contains("END")) {
                        break;
                    }
                }
                LineColor lnColor = new LineColor(lstLineColors);
                tempCase.lstLineColors.add(lnColor);

                contRulesCase--;
                if (contRulesCase == 0) {
                    lstCases.add(tempCase);
                    //System.out.println(tempCase.PrintCase());
                }
            }
        }
        return this;
    }

}
