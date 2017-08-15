/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycloak.shadule;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import keycloak.DAO.tUserLogDAO;

/**
 *
 * @author vasil
 */
@Singleton
public class shaduler {

    public EntityManager em = Persistence.createEntityManagerFactory("keycloak_shadule_jar_1PU").createEntityManager();
    @Schedule(minute="*/2", hour="*")
    public void shTimer() {
        tUserLogDAO logDAO = new tUserLogDAO(em);
        
        System.out.println("Timer = " + logDAO.getList().size());
    }

}
