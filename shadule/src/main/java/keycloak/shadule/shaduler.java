/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycloak.shadule;

import java.util.List;
import javax.ejb.Local;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreUpdate;
import keycloak.DAO.TUserLogDAO;
import keycloak.Entity.TUsersLog;
import org.jboss.logging.Logger;

/**
 *
 * @author vasil
 */
@Singleton
@Local(shaduler.class)
public class shaduler {
    
    @PersistenceContext
    protected EntityManager em;
    
    private Logger log = Logger.getLogger(shaduler.class);
    private int i = 0;
    
    @PreUpdate
    public void preUpdate() {
        log.debug("preUpdate");
    }
    
    @PostConstruct
    public void postConstruct() {
        log.debug("postConstruct");
        //this.em = Persistence.createEntityManagerFactory("shadule-jpa").createEntityManager();
    }
    
    public shaduler() {
        log.debug("constructor");
        try {
            
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    
    @Schedule(minute = "*/1", hour = "*")
    public void shTimer() {
        try {            
            i++;
            log.info("Timer => " + i);
            List<TUsersLog> itemList = (new TUserLogDAO(em)).getList();
            log.info("size => " + itemList.size());
            itemList.forEach(item -> {
                log.info(item);
                item.setFlag(true);
                em.merge(item);
            });
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    
}
