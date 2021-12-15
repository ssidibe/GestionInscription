/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.managedbean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sn.ugb.ipsl.gestioninscription.entities.Utilisateur;
import sn.ugb.ipsl.gestioninscription.entitiesfacades.UtilisateurFacade;
import sn.ugb.ipsl.gestioninscription.services.IpslAuthentificationException;
import sn.ugb.ipsl.gestioninscription.services.IpslLoggerService;

/**
 *
 * @author samba
 */
@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    @EJB
    private IpslLoggerService loggerService;
    @EJB
    private UtilisateurFacade userFacade;

    @Inject
    private UserBean userBean;

    private String emailOuTel;
    private String pwd;

    public LoginBean() {
    }

    public String getEmailOuTel() {
        return emailOuTel;
    }

    public void setEmailOuTel(String emailOuTel) {
        this.emailOuTel = emailOuTel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void connexion() {
        System.out.println("connexion........................");
        loggerService.details("authentification de l'utilisateur " + emailOuTel + " ..... ");
        Utilisateur user;
        try {
            user = userFacade.authentifie(emailOuTel, pwd);
            userBean.setUser(user);
            userBean.setPage("dashboard.xhtml"); 
            loggerService.details("user connecte " + user + " ..... ");
        } catch (IpslAuthentificationException ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(ex.getMessage());
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
        }
    }

}
