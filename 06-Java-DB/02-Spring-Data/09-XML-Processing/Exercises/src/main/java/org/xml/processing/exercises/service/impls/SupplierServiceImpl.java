package org.xml.processing.exercises.service.impls;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.processing.exercises.data.entities.Supplier;
import org.xml.processing.exercises.repositories.SupplierRepository;
import org.xml.processing.exercises.service.SupplierService;
import org.xml.processing.exercises.service.dtos.imports.SuppliersDto;
import org.xml.processing.exercises.utils.XmlParser;

import java.io.File;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String XML_IMPORT_PATH = "src/main/resources/xmls/import/suppliers.xml";

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSuppliers() throws JAXBException {
        SuppliersDto suppliersDto = xmlParser.importFile(SuppliersDto.class, XML_IMPORT_PATH);

        suppliersDto.getSuppliers().forEach(s ->
                this.supplierRepository.saveAndFlush(this.modelMapper.map(s, Supplier.class)));
    }

    @Override
    public boolean isImported() {
        return this.supplierRepository.count() > 0;
    }
}
