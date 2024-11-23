package org.xml.processing.exercises.service.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.processing.exercises.data.entities.Car;
import org.xml.processing.exercises.data.entities.Part;
import org.xml.processing.exercises.repositories.CarRepository;
import org.xml.processing.exercises.repositories.PartRepository;
import org.xml.processing.exercises.service.CarService;
import org.xml.processing.exercises.service.dtos.export.CarAndPartsDto;
import org.xml.processing.exercises.service.dtos.export.CarsAndPartsDto;
import org.xml.processing.exercises.service.dtos.export.CarsExportDto;
import org.xml.processing.exercises.service.dtos.export.PartExportDto;
import org.xml.processing.exercises.service.dtos.imports.CarsDto;
import org.xml.processing.exercises.utils.XmlParser;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static final String XML_IMPORT_PATH = "src/main/resources/xmls/import/cars.xml";
    private static final String XML_EXPORT_TOYOTA_PATH = "src/main/resources/xmls/export/toyota-cars.xml";
    private static final String XML_CARS_PARTS_PATH = "src/main/resources/xmls/export/cars-parts.xml";

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCars() {
        CarsDto carsDto = this.xmlParser.importFile(CarsDto.class, XML_IMPORT_PATH);

        carsDto.getCars().forEach(c -> {
            Car car = this.modelMapper.map(c, Car.class);
            car.setParts(getRandomParts());

            this.carRepository.saveAndFlush(car);
        });
    }

    @Override
    public void exportToyotaCars() {
        HashSet<CarsExportDto> carExportDtos = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(c -> this.modelMapper.map(c, CarsExportDto.class))
                .collect(Collectors.toCollection(HashSet::new));

        CarsExportDto carsExportDto = new CarsExportDto(carExportDtos);
        this.xmlParser.exportFile(carsExportDto, XML_EXPORT_TOYOTA_PATH);
    }

    @Override
    public void exportCarsAndParts() {
        Set<CarAndPartsDto> carsAndParts = this.carRepository.findAll()
                .stream()
                .map(c -> {
                    CarAndPartsDto carAndPartsDto = this.modelMapper.map(c, CarAndPartsDto.class);
                    carAndPartsDto.setParts(c.getParts()
                            .stream()
                            .map(p -> this.modelMapper.map(p, PartExportDto.class))
                            .collect(Collectors.toSet()));

                    return carAndPartsDto;
                })
                .collect(Collectors.toSet());

        CarsAndPartsDto carsAndPartsDto = new CarsAndPartsDto();
        carsAndPartsDto.setCarAndPartsDtos(carsAndParts);
        this.xmlParser.exportFile(carsAndPartsDto, XML_CARS_PARTS_PATH);
    }

    @Override
    public boolean isImported() {
        return this.carRepository.count() > 0;
    }


    private Set<Part> getRandomParts() {
        HashSet<Part> parts = new HashSet<>();

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3, 6); i++) {
            parts.add(this.partRepository.findById(
                    ThreadLocalRandom.current().nextInt(1,
                    (int) (this.partRepository.count() + 1))).orElse(null));
        }

        return parts;
    }
}
