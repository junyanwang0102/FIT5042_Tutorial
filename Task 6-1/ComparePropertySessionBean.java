/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.CreateException;
import javax.ejb.Stateful;
//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * 
 */
@Stateful 
// Stateless - if another client (e.g. another instance of the bean) is trying to access the bean , the container may give the existing instance to that client. 
  //So the state can be modified by the new client. In other words, no separate bean instances for each client.
//Stateful, there will be separate bean instance for each client.
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote {

    ArrayList<Integer> list;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addPropertyID(int propertyID) {
        list.add(propertyID);
    }

    @Override
    public void removePropertyID(int propertyID) {
        list.remove(new Integer(propertyID));
    }    

    @Override
    public int bestPerRoom() {
        Integer bestID=0;
        Property P;
        int numberOfRooms;
        double price;
        double bestPerRoom=100000000.00;
        for(Integer propertyID : list)
        {
            P=entityManager.find(Property.class, propertyID);
            numberOfRooms=P.getNumberOfBedrooms();
            price=P.getPrice();
            if(price/numberOfRooms<bestPerRoom)
            {
                bestPerRoom=price/numberOfRooms;
                bestID=P.getPropertyId();
            }
        }
        return bestID;
    }

    /**
     *
     * @return 
     * @throws javax.ejb.CreateException
     * @throws java.rmi.RemoteException
     */
    @PostConstruct
    public void init() {
        list=new ArrayList<>();
    }

    public ComparePropertySessionBeanRemote create() throws CreateException, RemoteException {
        return null;
    }

    public void ejbCreate() throws CreateException {
    }

}
