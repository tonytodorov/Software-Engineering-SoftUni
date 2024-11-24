package org.xml.processing.jaxb.entities;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "person")
public class Person {

    @XmlElement
    private Names names;

    @XmlElement
    private int age;

    @XmlElement
    private Address address;

    @XmlElementWrapper
    @XmlElement(name = "phone")
    List<PhoneNumber> phoneNumbers;

    public Person() {}

    public Person(Names names, int age, Address address, List<PhoneNumber> phoneNumbers) {
        this.names = names;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }
}
