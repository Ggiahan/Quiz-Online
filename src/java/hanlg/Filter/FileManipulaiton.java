/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author DELL
 */
public class FileManipulaiton   {

    public Map<String, String> getFuntionsMapFile(String path) {
	Map<String, String> functionMap = new HashMap<>();

	FileReader fr = null;
	BufferedReader br = null;

	try {
	    fr = new FileReader(path);
	    br = new BufferedReader(fr);

	    while (br.ready()) {
		String row = br.readLine();
		String[] arr = row.split("=");
		String key = arr[0];
		String action = arr[1];

		functionMap.put(key, action);
	    }
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(FileManipulaiton.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(FileManipulaiton.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if (br != null) {
		    br.close();
		}
		if (fr != null) {
		    fr.close();
		}
	    } catch (IOException ex) {
		Logger.getLogger(FileManipulaiton.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return functionMap;
    }

  
}
