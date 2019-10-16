/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author andrew
 */
@Named(value = "webServiceBean")
@SessionScoped
public class WebServiceBean implements Serializable {

    private String name;
    private HelloWorldWebServiceClient webServiceClient;
    /**
     * Creates a new instance of WebServiceBean
     */
    public WebServiceBean() {
    }
    
    public void setWebServiceClient(){
        this.webServiceClient = new HelloWorldWebServiceClient();
        webServiceClient.setPostNameForm(getName());
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    static class HelloWorldWebServiceClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:13562/Wk8ExeStudent/webresources";

        public HelloWorldWebServiceClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("greeting");
        }

        public void setPostName() throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
        }
        
        public void setPostNameForm(String name) throws ClientErrorException {
            Form form = new Form();
            form.param("name", name);
            webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE)); 
        }

        public String getXml() throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
        }

        public void putXml(Object requestEntity) throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
        }

        public void close() {
            client.close();
        }
    }

    
    
    
}
