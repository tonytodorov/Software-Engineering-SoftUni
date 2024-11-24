package org.xml.processing.exercises.utils;

import jakarta.xml.bind.*;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings(value = "unchecked")
    public <E> E importFile(Class<E> clazz, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (E) unmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <E> void exportFile(E object, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
