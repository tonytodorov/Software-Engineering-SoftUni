package org.xml.processing.exercises.service.impls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.processing.exercises.data.entities.Car;
import org.xml.processing.exercises.data.entities.Customer;
import org.xml.processing.exercises.data.entities.Part;
import org.xml.processing.exercises.data.entities.Sale;
import org.xml.processing.exercises.repositories.CarRepository;
import org.xml.processing.exercises.repositories.CustomerRepository;
import org.xml.processing.exercises.repositories.SaleRepository;
import org.xml.processing.exercises.service.SaleService;
import org.xml.processing.exercises.service.dtos.export.CarExportDto;
import org.xml.processing.exercises.service.dtos.export.SaleExportDto;
import org.xml.processing.exercises.service.dtos.export.SalesExportDto;
import org.xml.processing.exercises.utils.XmlParser;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private static final String XML_EXPORT = "src/main/resources/xmls/export/sales.xml";

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CustomerRepository customerRepository, CarRepository carRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSales() {

        List<Double> numbers = List.of(0.0, 0.05, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50);

        for (int i = 0; i < 35; i++) {
            Sale sale = new Sale();
            sale.setDiscount(numbers.get(ThreadLocalRandom.current().nextInt(1, numbers.size())));
            sale.setCar(getRandomCar());
            sale.setCustomer(getRandomCustomer());

            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public void exportSales() {
        Set<SaleExportDto> saleExportDtos = this.saleRepository.findAll()
                .stream()
                .map(s -> {
                    SaleExportDto saleExportDto = new SaleExportDto();
                    saleExportDto.setDiscount(s.getDiscount());
                    saleExportDto.setCustomerName(s.getCustomer().getName());
                    saleExportDto.setCar(this.modelMapper.map(s.getCar(), CarExportDto.class));
                    saleExportDto.setPrice(s.getCar()
                            .getParts()
                            .stream()
                            .map(Part::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add));
                    saleExportDto.setPriceWithDiscount(saleExportDto.getPrice().multiply(BigDecimal.valueOf(s.getDiscount())));
                    return saleExportDto;
                })
                .collect(Collectors.toSet());

        SalesExportDto salesExportDto = new SalesExportDto();
        salesExportDto.setSales(saleExportDtos);
        this.xmlParser.exportFile(salesExportDto, XML_EXPORT);
    }

    private Customer getRandomCustomer() {
        return this.customerRepository.findById(ThreadLocalRandom.current()
                .nextInt(1, (int) (this.customerRepository.count() + 1)))
                .get();
    }

    private Car getRandomCar() {
        return this.carRepository.findById(ThreadLocalRandom.current()
                .nextInt(1, (int) (this.carRepository.count() + 1)))
                .get();
    }

    @Override
    public boolean isImported() {
        return this.saleRepository.count() > 0;
    }
}
