package org.json.processing.gson;


import com.google.gson.annotations.Expose;

import java.util.Date;

public class PersonDTO {

    @Expose
    private String firstName;

    private String lastName;

    @Expose
    private int age;

    @Expose
    private AddressDTO addressDTO;

    private boolean isDeleted;

    private Date createdAt;

    public PersonDTO(String firstName, String lastName, int age, AddressDTO addressDTO, boolean isDeleted, Date createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressDTO = addressDTO;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", addressDTO=" + addressDTO +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
