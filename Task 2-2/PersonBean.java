package com.fit5042.mbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jian
 */
@Named(value = "personBean")
// TODO You can change to @ApplicationScoped and see the difference
@SessionScoped
public class PersonBean implements Serializable {

    private String message;
    private String name;
    private int age;

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
        this.age = 18;
    }

}
