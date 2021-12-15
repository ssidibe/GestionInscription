/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.entitiesfacades;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sn.ugb.ipsl.gestioninscription.entities.Utilisateur;
import sn.ugb.ipsl.gestioninscription.services.CryptoService;
import sn.ugb.ipsl.gestioninscription.services.IpslAuthentificationException;

/**
 *
 * @author Samba SIDIBE
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "sn.ugb.ipsl.GestionInscription")
    private EntityManager em;

    @EJB
    private CryptoService cryptoService;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    public Utilisateur authentifie(String emailOuTel, String pwd) throws IpslAuthentificationException {
        Query query = em.createNamedQuery("Utilisateur.authentifieUser");
        query.setParameter("emailTel", emailOuTel);
        List<Utilisateur> users = query.getResultList();
        if (users == null || users.isEmpty()) {
            throw new IpslAuthentificationException("login ou mot de passe incorrect");
        }
        if (users.size() == 1) {
            Utilisateur user = users.get(0);
            String md5 = cryptoService.md5Base64(pwd);
            if (md5.equals(user.getPassword())) {
                return user;
            } else {
                throw new IpslAuthentificationException("login ou mot de passe incorrect");
            }
        }
        throw new RuntimeException("erreur grave plusieurs utilisateurs pour le meme login");
    }

}
