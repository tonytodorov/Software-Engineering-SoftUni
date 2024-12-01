package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static final String CONSTELLATIONS_PATH = "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder sb = new StringBuilder();

        ConstellationImportDto[] constellationImportDtos = this.gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class);

        for (ConstellationImportDto constellationImportDto : constellationImportDtos) {
            if (this.constellationRepository.findByName(constellationImportDto.getName()).isPresent() ||
                    !this.validationUtil.isValid(constellationImportDto)) {
                sb.append("Invalid constellation").append(System.lineSeparator());
                continue;
            }

            Constellation constellation = this.modelMapper.map(constellationImportDto, Constellation.class);
            this.constellationRepository.saveAndFlush(constellation);

            sb.append(String.format("Successfully imported constellation %s - %s",
                    constellation.getName(),
                    constellation.getDescription()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
