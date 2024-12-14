package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VisitorImportDto;
import softuni.exam.models.dto.VisitorImportRootDto;
import softuni.exam.models.entity.PersonalData;
import softuni.exam.models.entity.Visitor;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.PersonalDataRepository;
import softuni.exam.repository.VisitorRepository;
import softuni.exam.service.VisitorService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {

    private static final String VISITORS_PATH = "src/main/resources/files/xml/visitors.xml";

    private final VisitorRepository visitorRepository;
    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final PersonalDataRepository personalDataRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository, AttractionRepository attractionRepository, CountryRepository countryRepository, PersonalDataRepository personalDataRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.visitorRepository = visitorRepository;
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.personalDataRepository = personalDataRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.visitorRepository.count() > 0;
    }

    @Override
    public String readVisitorsFileContent() throws IOException {
        return Files.readString(Path.of(VISITORS_PATH));
    }

    @Override
    public String importVisitors() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        VisitorImportRootDto visitorImportRootDto = this.xmlParser.fromFile(VISITORS_PATH, VisitorImportRootDto.class);

        for (VisitorImportDto visitorImportDto : visitorImportRootDto.getVisitors()) {
            Long personalDataId = visitorImportDto.getPersonalDataId();
            Optional<PersonalData> byId = this.personalDataRepository.findById(personalDataId);

            if (this.visitorRepository.findByFirstNameAndLastName(visitorImportDto.getFirstName(), visitorImportDto.getLastName()).isPresent() ||
                    this.visitorRepository.findByPersonalData(byId.get()).isPresent() ||
                    !this.validationUtil.isValid(visitorImportDto)) {
                sb.append("Invalid visitor").append(System.lineSeparator());
                continue;
            }

            Visitor visitor = this.modelMapper.map(visitorImportDto, Visitor.class);

            visitor.setAttraction(this.attractionRepository.findById(visitorImportDto.getAttractionId()).get());
            visitor.setCountry(this.countryRepository.findById(visitorImportDto.getCountryId()).get());
            visitor.setPersonalData(this.personalDataRepository.findById(visitorImportDto.getPersonalDataId()).get());

            this.visitorRepository.saveAndFlush(visitor);

            sb.append(String.format("Successfully imported visitor %s %s",
                    visitor.getFirstName(),
                    visitor.getLastName()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
