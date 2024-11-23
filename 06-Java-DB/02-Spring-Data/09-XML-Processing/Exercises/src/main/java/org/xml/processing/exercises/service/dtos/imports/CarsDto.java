package org.xml.processing.exercises.service.dtos.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsDto {

    @XmlElement(name = "car")
    private Set<CarDto> cars;

    public Set<CarDto> getCars() {
        return cars;
    }

    public void setCars(Set<CarDto> cars) {
        this.cars = cars;
    }
}
