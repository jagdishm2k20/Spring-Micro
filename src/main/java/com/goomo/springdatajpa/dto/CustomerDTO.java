package com.goomo.springdatajpa.dto;

import java.io.Serializable;

public class CustomerDTO  implements Serializable{
    

    private static final long serialVersionUID = 1L;

    private String id;
    
    private String firstname;

    private String lastname;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CustomerDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }

    

}
