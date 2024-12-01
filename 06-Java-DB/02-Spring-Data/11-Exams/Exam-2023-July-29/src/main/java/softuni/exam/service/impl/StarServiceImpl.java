package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Star;
import softuni.exam.models.enums.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StarServiceImpl implements StarService {

    private static final String STARS_PATH = "src/main/resources/files/json/stars.json";

    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();

        StarImportDto[] starImportDtos = this.gson.fromJson(readStarsFileContent(), StarImportDto[].class);

        for (StarImportDto starImportDto : starImportDtos) {
            if (this.starRepository.findByName(starImportDto.getName()).isPresent() ||
                    !this.validationUtil.isValid(starImportDto)) {
                sb.append("Invalid star").append(System.lineSeparator());
                continue;
            }

            Star star = this.modelMapper.map(starImportDto, Star.class);
            star.setStarType(StarType.valueOf(starImportDto.getStartType()));
            star.setConstellation(this.constellationRepository.findById(starImportDto.getConstellation()).get());

            this.starRepository.saveAndFlush(star);

            sb.append(String.format("Successfully imported star %s - %.2f light years",
                    star.getName(),
                    star.getLightYears()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportStars() {
        StringBuilder sb = new StringBuilder();

        this.starRepository.findAllByStarTypeAndObservedIsNullOrderByLightYearsAsc(StarType.RED_GIANT)
                .forEach(s -> {
                    sb.append(String.format("Star: %s\n" +
                            "   *Distance: %.2f light years\n" +
                            "   **Description: %s\n" +
                            "   ***Constellation: %s",
                            s.getName(),
                            s.getLightYears(),
                            s.getDescription(),
                            s.getConstellation().getName()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
