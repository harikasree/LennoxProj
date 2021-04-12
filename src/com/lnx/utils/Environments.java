package com.lnx.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//import com.ebs.properties.Environments;
//import com.ebs.utils.PropertiesReader;

public class Environments {

	static Properties Objrepository = new Properties();
	public static String Objrepos=System.getProperty("user.dir")+"//Resources//environments.properties";

//    private Environments() {
//    }
//
//    static Environments getInstance() {
//        if (instance == null) {
//            instance = new Environments();
//            init();
//        }
//        return instance;
//    }

//    private static void init() {
//        try {
//
//            environments = PropertiesReader.readProperties(propFileName);
//        } catch (Exception e) {
//            System.out.println("Environments property file " + propFileName + "not found. Execution stopped!");
//            System.exit(1);
//        }
//    }

    public String getEnvironmentsProperty(String propertyName) throws IOException {
    	FileInputStream Objrepositoryfile = new FileInputStream(Objrepos);
		 Objrepository.load(Objrepositoryfile);
		 return Objrepository.getProperty(propertyName);
    }

}
