/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Samba SIDIBE
 */
@Entity
@Table(name = "user_roles")
@IdClass(UserRolePk.class)
public class UserRole implements Serializable {

    @Id
    @ManyToOne
    private Utilisateur user;

    @Id
    @ManyToOne
    private Role role;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateModification;

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    @PrePersist
    public void controleAvantEnregistrement() {
        Date d = new Date();
        dateCreation = d;
        dateModification = d;
    }

    @PreUpdate
    public void controleAvantModif() {
        dateModification = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserRole other = (UserRole) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

}
