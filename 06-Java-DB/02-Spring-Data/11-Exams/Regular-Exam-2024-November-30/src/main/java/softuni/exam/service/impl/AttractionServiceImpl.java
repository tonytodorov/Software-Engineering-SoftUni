package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AttractionImportDto;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Attraction;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.AttractionRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.AttractionService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {

    private static final String ATTRACTIONS_PATH = "src/main/resources/files/json/attractions.json";

    private final AttractionRepository attractionRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public AttractionServiceImpl(AttractionRepository attractionRepository, CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.attractionRepository = attractionRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.attractionRepository.count() > 0;
    }

    @Override
    public String readAttractionsFileContent() throws IOException {
        return Files.readString(Path.of(ATTRACTIONS_PATH));
    }

    @Override
    public String importAttractions() throws IOException {
        StringBuilder sb = new StringBuilder();

        AttractionImportDto[] attractionImportDtos = this.gson.fromJson(readAttractionsFileContent(), AttractionImportDto[].class);

        for (AttractionImportDto attractionImportDto : attractionImportDtos) {
            if (this.attractionRepository.findByName(attractionImportDto.getName()).isPresent() ||
                    !this.validationUtil.isValid(attractionImportDto)) {
                sb.append("Invalid attraction").append(System.lineSeparator());
                continue;
            }

            Attraction attraction = this.modelMapper.map(attractionImportDto, Attraction.class);
            attraction.setCountry(this.countryRepository.findById(attractionImportDto.getCountry()).get());
            this.attractionRepository.saveAndFlush(attraction);

            sb.append(String.format("Successfully imported attraction %s",
                            attraction.getName()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportAttractions() {
        StringBuilder sb = new StringBuilder();

        this.attractionRepository.findHistoricalAndArchaeologicalSitesWithElevation()
                .forEach(a -> {
                    sb.append(String.format("Attraction with ID%d:\n" +
                            "***%s - %s at an altitude of %dm. somewhere in %s.\n",
                            a.getId(),
                            a.getName(),
                            a.getDescription(),
                            a.getElevation(),
                            a.getCountry().getName()));
                });

        return sb.toString();
    }
}
