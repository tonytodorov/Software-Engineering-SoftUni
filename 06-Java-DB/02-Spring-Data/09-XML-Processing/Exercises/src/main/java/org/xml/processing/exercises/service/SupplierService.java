package org.xml.processing.exercises.service;

import jakarta.xml.bind.JAXBException;

public interface SupplierService extends BaseService {

    void seedSuppliers() throws JAXBException;
}
