package org.xml.processing.exercises.service.dtos.export;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersOrderedDto {

    @XmlElement(name = "customer")
    private Set<CustomerOrderedDto> customers;

    public CustomersOrderedDto() {}

    public CustomersOrderedDto(Set<CustomerOrderedDto> customers) {
        this.customers = customers;
    }

    public Set<CustomerOrderedDto> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerOrderedDto> customers) {
        this.customers = customers;
    }
}
