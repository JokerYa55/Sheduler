/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycloak.shadule;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author vasil
 */
@Singleton
public class shaduler {

    @Schedule(minute="*/3", hour="*")
    public void shTimer() {
        System.out.println("Timer");
    }

}
