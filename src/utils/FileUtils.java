/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author hangarita
 */
public class FileUtils {
    
    public static String strRoot = System.getProperty("user.dir");
    
    public static File Read(String strPath) throws IOException{
        File fXmlFile = new File(strPath);
	return fXmlFile;
    }
}
