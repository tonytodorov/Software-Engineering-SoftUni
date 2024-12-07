package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanologistImportDto;
import softuni.exam.models.dto.VolcanologistImportRootDto;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {

    private static final String VOLCANOLOGISTS_PATH = "src/main/resources/files/xml/volcanologists.xml";

    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoRepository volcanoRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, VolcanoRepository volcanoRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoRepository = volcanoRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return Files.readString(Path.of(VOLCANOLOGISTS_PATH));
    }

    @Override
    public String importVolcanologists() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        VolcanologistImportRootDto volcanologistImportRootDto = this.xmlParser.fromFile(VOLCANOLOGISTS_PATH, VolcanologistImportRootDto.class);

        for (VolcanologistImportDto volcanologistImportDto : volcanologistImportRootDto.getVolcanologistImportDtos()) {
            if (this.volcanologistRepository.findByFirstNameAndLastName(volcanologistImportDto.getFirstName(), volcanologistImportDto.getLastName()).isPresent() ||
                this.volcanoRepository.findById((long) volcanologistImportDto.getExploringVolcanoId()).isEmpty() ||
                !this.validationUtil.isValid(volcanologistImportDto)) {

                sb.append("Invalid volcanologist").append(System.lineSeparator());
                continue;
            }

            Volcanologist volcanologist = this.modelMapper.map(volcanologistImportDto, Volcanologist.class);
            volcanologist.setVolcano(this.volcanoRepository.findById((long) volcanologistImportDto.getExploringVolcanoId()).get());
            this.volcanologistRepository.saveAndFlush(volcanologist);

            sb.append(String.format("Successfully imported volcanologist %s %s",
                    volcanologistImportDto.getFirstName(),
                    volcanologistImportDto.getLastName()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}