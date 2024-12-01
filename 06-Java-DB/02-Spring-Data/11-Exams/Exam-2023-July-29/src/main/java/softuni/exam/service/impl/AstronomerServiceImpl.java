package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDto;
import softuni.exam.models.dto.AstronomerImportRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static final String ASTRONOMERS_PATH = "src/main/resources/files/xml/astronomers.xml";

    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        AstronomerImportRootDto astronomerImportRootDto = this.xmlParser.fromFile(ASTRONOMERS_PATH, AstronomerImportRootDto.class);

        for (AstronomerImportDto astronomersImportDto : astronomerImportRootDto.getAstronomersImportDtos()) {
            if (this.astronomerRepository.findByFirstNameAndLastName(astronomersImportDto.getFirstName(), astronomersImportDto.getLastName()).isPresent() ||
                    this.starRepository.findById(astronomersImportDto.getObservingStarId()).isEmpty() ||
                    !this.validationUtil.isValid(astronomersImportDto)) {
                sb.append("Invalid astronomer").append(System.lineSeparator());
                continue;
            }

            Astronomer astronomer = this.modelMapper.map(astronomersImportDto, Astronomer.class);
            astronomer.setObservingStar(this.starRepository.findById(astronomersImportDto.getObservingStarId()).get());

            this.astronomerRepository.saveAndFlush(astronomer);

            sb.append(String.format("Successfully imported astronomer %s %s - %.2f",
                    astronomer.getFirstName(),
                    astronomer.getLastName(),
                    astronomer.getAverageObservationHours()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
