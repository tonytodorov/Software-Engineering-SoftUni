package org.xml.processing.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.processing.jaxb.entities.Address;
import org.xml.processing.jaxb.entities.Names;
import org.xml.processing.jaxb.entities.Person;
import org.xml.processing.jaxb.entities.PhoneNumber;

import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Names names = new Names("First", "Last");

        Person person = new Person(
                names,
                20,
                new Address("BG", "Plovdiv"),
                List.of(new PhoneNumber("085892421"), new PhoneNumber("5182591")));

        JAXBContext nameContext = JAXBContext.newInstance(Names.class);
        Marshaller nameMarshaller = nameContext.createMarshaller();
        nameMarshaller.marshal(person, System.out);

        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(person, System.out);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Person fromXML = (Person) unmarshaller.unmarshal(System.in);

        System.out.println(fromXML);
    }
}