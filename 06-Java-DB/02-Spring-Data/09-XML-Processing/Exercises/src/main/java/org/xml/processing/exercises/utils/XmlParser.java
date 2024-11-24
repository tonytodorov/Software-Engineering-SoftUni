package org.xml.processing.exercises.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.xml.processing.exercises.service.dtos.imports.SuppliersDto;

import java.io.File;

public interface XmlParser {

    <E> E importFile(Class<E> clazz, String path);

    <E> void exportFile(E object, String path);


}
