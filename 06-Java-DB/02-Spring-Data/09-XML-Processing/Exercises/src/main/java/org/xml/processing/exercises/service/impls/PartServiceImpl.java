package org.xml.processing.exercises.service.impls;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.processing.exercises.data.entities.Part;
import org.xml.processing.exercises.data.entities.Supplier;
import org.xml.processing.exercises.repositories.PartRepository;
import org.xml.processing.exercises.repositories.SupplierRepository;
import org.xml.processing.exercises.service.PartService;
import org.xml.processing.exercises.service.dtos.imports.PartsDto;
import org.xml.processing.exercises.utils.XmlParser;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {

    private static final String XML_IMPORT_PATH = "src/main/resources/xmls/import/parts.xml";

    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedParts() throws JAXBException {
        PartsDto partsDto = this.xmlParser.importFile(PartsDto.class, XML_IMPORT_PATH);
        partsDto.getParts().forEach(p -> {
            Part part = this.modelMapper.map(p, Part.class);
            part.setSupplier(getRandomSupplier());

            this.partRepository.saveAndFlush(part);
        });
    }
    @Override
    public boolean isImported() {
        return this.partRepository.count() > 0;
    }

    private Supplier getRandomSupplier() {
        int random = ThreadLocalRandom.current().nextInt(1, (int) (this.supplierRepository.count() + 1));
        return this.supplierRepository.findById(random).orElse(null);
    }
}
