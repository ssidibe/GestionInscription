/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sn.ugb.ipsl.gestioninscription.entitiesfacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sn.ugb.ipsl.gestioninscription.entities.UserRole;

/**
 *
 * @author Samba SIDIBE
 */
@Stateless
public class UserRoleFacade extends AbstractFacade<UserRole> {

    @PersistenceContext(unitName = "sn.ugb.ipsl.GestionInscription")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRoleFacade() {
        super(UserRole.class);
    }

}
