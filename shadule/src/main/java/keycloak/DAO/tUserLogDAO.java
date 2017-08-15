/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycloak.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.jboss.logging.Logger;
import keycloak.Entity.TUsersLog;

/**
 *
 * @author vasil
 */
public class tUserLogDAO {
    
    private static final Logger log = Logger.getLogger(tUserLogDAO.class);
    private final EntityManager em;
    public tUserLogDAO(EntityManager em) {
        this.em = em;
    }
    
    
    
    public TUsersLog getItem(String id) {
        TUsersLog res = null;
        try {
            
        } catch (Exception e) {
            
        }
        return res;
    }
    
    public TUsersLog getItemByName(String name) {
        TUsersLog res = null;
        try {
            
        } catch (Exception e) {
            
        }
        return res;
    }
    
    public List<TUsersLog> getList(){
        Query q = em.createQuery("select m from TUsersLog m");
        return q.getResultList();
    }
}
