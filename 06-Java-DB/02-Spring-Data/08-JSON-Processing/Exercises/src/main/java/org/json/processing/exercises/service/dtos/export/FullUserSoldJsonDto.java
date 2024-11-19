package org.json.processing.exercises.service.dtos.export;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class FullUserSoldJsonDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private SoldProductDto soldProducts;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SoldProductDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
