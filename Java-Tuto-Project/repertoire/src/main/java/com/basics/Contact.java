package com.basics;

public class Contact {

    private String lastName;
    private String firstName;
    private String phoneNumber;

    // constructors

    public Contact(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        // this.phoneNumber = null;
    }

    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    // Getter, setter
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {

        return this.firstName + " " + this.lastName + " | " + this.phoneNumber;

    }

}
