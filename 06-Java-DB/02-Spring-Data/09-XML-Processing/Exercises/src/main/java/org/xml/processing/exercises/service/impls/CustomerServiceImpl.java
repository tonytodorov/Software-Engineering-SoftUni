package org.xml.processing.exercises.service.impls;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.processing.exercises.data.entities.Customer;
import org.xml.processing.exercises.repositories.CustomerRepository;
import org.xml.processing.exercises.service.CustomerService;
import org.xml.processing.exercises.service.dtos.export.CustomerOrderedDto;
import org.xml.processing.exercises.service.dtos.export.CustomersOrderedDto;
import org.xml.processing.exercises.service.dtos.imports.CustomersDto;
import org.xml.processing.exercises.utils.XmlParser;

import java.io.File;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String XML_IMPORT_PATH = "src/main/resources/xmls/import/customers.xml";
    private static final String XML_EXPORT_PATH = "src/main/resources/xmls/export/ordered-customers.xml";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCustomers() {
        CustomersDto customersDto = this.xmlParser.importFile(CustomersDto.class, XML_IMPORT_PATH);

        customersDto.getCustomers().forEach(c -> {
            Customer customer = this.modelMapper.map(c, Customer.class);
            customer.setBirthDate(LocalDate.parse(c.getBirthDate().split("T")[0]));
            this.customerRepository.saveAndFlush(customer);
        });
    }

    @Override
    public void exportOrderedCustomers() {
        Set<CustomerOrderedDto> customersOrderedDtos = this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriverDesc()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerOrderedDto.class))
                .collect(Collectors.toSet());

        CustomersOrderedDto customersOrderedDto =
                new CustomersOrderedDto(customersOrderedDtos);

        this.xmlParser.exportFile(customersOrderedDto, XML_EXPORT_PATH);
    }

    @Override
    public boolean isImported() {
        return this.customerRepository.count() > 0;
    }
}
