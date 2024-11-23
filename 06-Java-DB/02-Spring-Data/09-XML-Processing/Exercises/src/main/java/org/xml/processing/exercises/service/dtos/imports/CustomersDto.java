package org.xml.processing.exercises.service.dtos.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersDto {

    @XmlElement(name = "customer")
    private Set<CustomerDto> customers;

    public Set<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerDto> customers) {
        this.customers = customers;
    }
}
