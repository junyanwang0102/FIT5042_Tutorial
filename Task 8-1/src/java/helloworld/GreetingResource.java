/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author andrew
 */
@Path("greeting")
public class GreetingResource {

    @Context
    private UriInfo context;
    
    @EJB
    private NameStorageBean nameStorageBean;

    /**
     * Creates a new instance of GreetingResource
     */
    public GreetingResource() {
        
    }

    public void setNameStorageBean(NameStorageBean nameStorageBean){
        this.nameStorageBean = nameStorageBean;
    }
    
    public NameStorageBean getNameStorageBean() {
        return this.nameStorageBean;
    }
    
    /**
     * Retrieves representation of an instance of helloworld.GreetingResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml() {
        return "<html><body><h1>Hello " + nameStorageBean.getName() + "!</h1></body></html>";
    }

    /**
     * PUT method for updating or creating an instance of GreetingResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
        
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void setPostName(@FormParam("name") String name) {
        nameStorageBean.setName(name);
    }
}
