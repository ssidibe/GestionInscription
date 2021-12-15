/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import sn.ugb.ipsl.gestioninscription.entities.Utilisateur;

/**
 *
 * @author samba
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private String page = "connexion.xhtml";
    private Utilisateur user;

    public UserBean() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

}
