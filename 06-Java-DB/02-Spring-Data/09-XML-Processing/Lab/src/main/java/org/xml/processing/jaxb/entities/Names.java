package org.xml.processing.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Names {

    @XmlAttribute(name = "firstName")
    private String firstName;

    @XmlAttribute
    private String lastName;

    public Names() {}

    public Names(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
