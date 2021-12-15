/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.services;

import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sn.ugb.ipsl.gestioninscription.entities.Role;
import sn.ugb.ipsl.gestioninscription.entities.UserRole;
import sn.ugb.ipsl.gestioninscription.entities.Utilisateur;
import sn.ugb.ipsl.gestioninscription.entitiesfacades.RoleFacade;
import sn.ugb.ipsl.gestioninscription.entitiesfacades.UserRoleFacade;
import sn.ugb.ipsl.gestioninscription.entitiesfacades.UtilisateurFacade;

/**
 *
 * @author samba
 */
@Singleton
@Startup
public class InitApp {

    @EJB
    private RoleFacade roleFacade;

    @EJB
    private UtilisateurFacade utilisateurFacade;

    @EJB
    private IpslLoggerService loggerService;
    
    @EJB
    private CryptoService cryptoService;
    
    @EJB
    private UserRoleFacade userRoleFacade;

    @PostConstruct
    public void init() {
        loggerService.infos("demarrage de l'application");
        if (utilisateurFacade.count() == 0) {
            loggerService.setLogLevel(Level.FINEST);
            loggerService.details("initialisation de l'application");
            Role admin=new Role("admin");
            Role operateur=new Role("operateur");
            Role manager=new Role("gestion");
            Role candidat=new Role("candidat");
            roleFacade.create(admin);
            roleFacade.create(operateur);
            roleFacade.create(manager);
            roleFacade.create(candidat);

            Utilisateur adminUser=new Utilisateur();
            adminUser.setEmail("admin@ugb.edu.sn");
            String md5Pass=cryptoService.md5Base64("adminUGB");
            adminUser.setPassword(md5Pass);
            adminUser.setTelephone("+221765936161");
            adminUser.setPrenom("admin");
            adminUser.setNom("admin");
            utilisateurFacade.create(adminUser);
            
            UserRole userRole=new UserRole();
            userRole.setUser(adminUser);
            userRole.setRole(admin);
            userRoleFacade.create(userRole);
        } else {
            loggerService.setLogLevel(Level.INFO);
        }

    }
}
