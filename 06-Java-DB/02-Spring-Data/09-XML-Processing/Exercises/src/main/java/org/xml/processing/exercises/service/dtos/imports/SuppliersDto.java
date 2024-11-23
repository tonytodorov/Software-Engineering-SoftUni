package org.xml.processing.exercises.service.dtos.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersDto {

    @XmlElement(name = "supplier")
    private Set<SupplierDto> suppliers;


    public Set<SupplierDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<SupplierDto> suppliers) {
        this.suppliers = suppliers;
    }
}
