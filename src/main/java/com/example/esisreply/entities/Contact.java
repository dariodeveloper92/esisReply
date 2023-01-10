package com.example.esisreply.entities;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue //Autoincrement
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "type")
    private String type;

    @Column(name = "val")
    private String val;

    @Column(name = "certified")
    private Boolean certified;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable=false, updatable=false)
    private Customer customer;

    //GETTER
    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public String getVal() {
        return val;
    }

    public Boolean getCertified() {
        return certified;
    }

    public Customer getCustomer() {
        return customer;
    }

    //SETTER

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setCertified(Boolean certified) {
        this.certified = certified;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //toString()

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", type='" + type + '\'' +
                ", val='" + val + '\'' +
                ", certified='" + certified + '\'' +
                ", customer=" + customer +
                '}';
    }
}
