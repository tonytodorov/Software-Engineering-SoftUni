package org.xml.processing.exercises.service.dtos.export;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsAndPartsDto {

    @XmlElement(name = "car")
    private Set<CarAndPartsDto> carAndPartsDtos;

    public Set<CarAndPartsDto> getCarAndPartsDtos() {
        return carAndPartsDtos;
    }

    public void setCarAndPartsDtos(Set<CarAndPartsDto> carAndPartsDtos) {
        this.carAndPartsDtos = carAndPartsDtos;
    }
}
