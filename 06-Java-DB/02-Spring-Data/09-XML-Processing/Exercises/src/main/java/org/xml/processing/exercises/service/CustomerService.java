package org.xml.processing.exercises.service;

import jakarta.xml.bind.JAXBException;

public interface CustomerService extends BaseService {

    void seedCustomers();

    void exportOrderedCustomers() throws JAXBException;

}
