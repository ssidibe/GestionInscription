/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;


@Singleton
public class IpslLoggerService {

    private static final String LOGGING_TAG = "IPSL_GESTION_INSCRIPTION";
    private static final Logger IPSL_LOGGER = Logger.getLogger(LOGGING_TAG);

    public IpslLoggerService() {
    }

    public void log(Level level, String msg) {
        IPSL_LOGGER.log(level, msg);
    }

    public void erreur(String msg) {
        IPSL_LOGGER.log(Level.SEVERE, msg);
    }

    public void warning(String msg) {
        IPSL_LOGGER.log(Level.WARNING, msg);
    }

    public void infos(String msg) {
        IPSL_LOGGER.log(Level.INFO, msg);
    }

    public void details(String msg) {
        IPSL_LOGGER.log(Level.FINE, msg);
    }

    public void config(String msg) {
        IPSL_LOGGER.log(Level.CONFIG, msg);
    }
    
    public void setLogLevel(Level level){
        IPSL_LOGGER.setLevel(level);
    }

}
