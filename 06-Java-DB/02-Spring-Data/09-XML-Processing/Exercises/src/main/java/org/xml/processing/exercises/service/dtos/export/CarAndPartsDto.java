package org.xml.processing.exercises.service.dtos.export;

import jakarta.xml.bind.annotation.*;

import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarAndPartsDto {

    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;

    @XmlElementWrapper(name = "parts")
    private Set<PartExportDto> parts;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<PartExportDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartExportDto> parts) {
        this.parts = parts;
    }
}
