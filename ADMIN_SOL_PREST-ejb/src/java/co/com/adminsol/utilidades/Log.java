/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.chainsaw.Main;


public class Log {
     public static Logger logger = Logger.getLogger(Main.class.getName());
        

        public Log()
        {
                Properties properties= new Properties();
                Properties props = new Properties();
                String pathProp = System.getProperty("ConfigProperties");
                pathProp += "\\log4j.properties";
                try {
                        properties.load(new FileInputStream(pathProp));                        
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }       
                
                props.setProperty("log4j.appender.miArchivo", properties.getProperty("LOG4J.APPENDER.MIARCHIVO"));
                props.setProperty("log4j.appender.miArchivo.file", properties.getProperty("LOG4J.APPENDER.MIARCHIVO.FILE"));
                props.setProperty("log4j.appender.miArchivo.layout", properties.getProperty("LOG4J.APPENDER.MIARCHIVO.LAYOUT"));
                props.setProperty("log4j.appender.miArchivo.layout.ConversionPattern", properties.getProperty("LOG4J.APPENDER.MIARCHIVO.LAYOUT.CONVERSIONPATTERN"));
                props.setProperty("log4j.appender.miArchivo.append", properties.getProperty("LOG4J.APPENDER.MIARCHIVO.APPEND"));                                
                props.setProperty("log4j.rootLogger", properties.getProperty("LOG4J.ROOTLOGGER"));              
                PropertyConfigurator.configure(props);
        }
}
