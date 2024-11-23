package org.xml.processing.exercises.service.dtos.export;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsExportDto {

    @XmlElement(name = "car")
    private Set<CarsExportDto> cars;

    public CarsExportDto() {}

    public CarsExportDto(Set<CarsExportDto> cars) {
        this.cars = cars;
    }

    public Set<CarsExportDto> getCars() {
        return cars;
    }

    public void setCars(Set<CarsExportDto> cars) {
        this.cars = cars;
    }
}
