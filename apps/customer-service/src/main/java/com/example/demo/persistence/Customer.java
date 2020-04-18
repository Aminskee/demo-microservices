package com.example.demo.persistence;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = Customer.CUSTOMER_BY_FIRSTNAME, query = "SELECT C FROM Customer C WHERE C.firstName = :firstName"),
})
public class Customer {

    public static final String CUSTOMER_BY_FIRSTNAME = "Customer.findByFirstName";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private  String lastName;
    private  String firstName;

    protected Customer(){
    }
    public Customer (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
