package org.json.processing.gson;

import com.google.gson.annotations.Expose;

public class AddressDTO {

    @Expose
    private String country;

    @Expose
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
