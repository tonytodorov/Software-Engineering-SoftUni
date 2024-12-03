package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SaleImportDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.SaleRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SaleServiceImpl implements SaleService {

    private final static String SALES_PATH = "src/main/resources/files/json/sales.json";

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SellerRepository sellerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        return Files.readString(Path.of(SALES_PATH));
    }

    @Override
    public String importSales() throws IOException {
        StringBuilder sb = new StringBuilder();

        SaleImportDto[] saleImportDtos = this.gson.fromJson(readSalesFileContent(), SaleImportDto[].class);

        for (SaleImportDto saleImportDto : saleImportDtos) {
            if (this.saleRepository.findByNumber(saleImportDto.getNumber()).isPresent() ||
                    !this.validationUtil.isValid(saleImportDto)) {
                sb.append("Invalid sale").append(System.lineSeparator());
                continue;
            }

            Sale sale = this.modelMapper.map(saleImportDto, Sale.class);
            sale.setSaleDate(LocalDateTime.parse(saleImportDto.getSaleDate(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            sale.setSeller(this.sellerRepository.findById(saleImportDto.getSeller()).get());

            this.saleRepository.saveAndFlush(sale);

            sb.append(String.format("Successfully imported sale with number %s",
                    saleImportDto.getNumber()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
