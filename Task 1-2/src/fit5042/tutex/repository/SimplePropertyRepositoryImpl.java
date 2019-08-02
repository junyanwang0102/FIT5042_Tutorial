/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Jian 
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository{

    List<Property> repository;

    public SimplePropertyRepositoryImpl() {
        repository = new ArrayList<Property>();
    }
    
    @Override
    public void addProperty(Property property) throws Exception {
        repository.add(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        for(Property p : repository){
            if(p.getId() == id){
                System.out.println(p.toString());
                return p;
            }
        }
        System.out.println("Property not found.");
        return null;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return repository;
    }
    
    
    
}
