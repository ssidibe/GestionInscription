/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sn.ugb.ipsl.gestioninscription.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Samba SIDIBE
 */
public class UserRolePk implements Serializable{
    private Long user;
    private Byte role;

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

   

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.role);
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
        final UserRolePk other = (UserRolePk) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return Objects.equals(this.role, other.role);
    }
    
    
}
