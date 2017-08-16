/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycloak.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import keycloak.Entity.TUsersLog;
import keycloak.interfaces.daoInterface;
import org.jboss.logging.Logger;

/**
 *
 * @author vasil
 */
public class TUserLogDAO implements daoInterface<TUsersLog, Long> {
    
    private final EntityManager em;
    private final Logger log = Logger.getLogger(TUserLogDAO.class);

    public TUserLogDAO(EntityManager em) {
        this.em = em;
}
    
    @Override
    public EntityManager getEM() {
        return this.em;
    }

    @Override
    public TUsersLog getItem(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TUsersLog> getList() {
        List<TUsersLog> res = null;
        try {
            TypedQuery<TUsersLog> namedQuery = em.createNamedQuery("TUsersLog.findAll", TUsersLog.class);
            res = namedQuery.getResultList();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return res;
    }

    @Override
    public List<TUsersLog> getList(Long startIdx, Long stopIdx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
