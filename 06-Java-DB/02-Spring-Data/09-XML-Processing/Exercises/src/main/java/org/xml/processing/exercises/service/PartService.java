package org.xml.processing.exercises.service;

import jakarta.xml.bind.JAXBException;

public interface PartService extends BaseService {

    void seedParts() throws JAXBException;
}
