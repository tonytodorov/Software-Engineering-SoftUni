package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceImportDto;
import softuni.exam.models.dto.DeviceImportRootDto;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final static String DEVICES_PATH = "src/main/resources/files/xml/devices.xml";

    private final DeviceRepository deviceRepository;
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, SaleRepository saleRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.deviceRepository = deviceRepository;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return Files.readString(Path.of(DEVICES_PATH));
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        DeviceImportRootDto deviceImportRootDtos = this.xmlParser.fromFile(DEVICES_PATH, DeviceImportRootDto.class);

        for (DeviceImportDto deviceImportDto : deviceImportRootDtos.getDeviceImportDtos()) {
            if (this.deviceRepository.findByBrandAndModel(deviceImportDto.getBrand(), deviceImportDto.getModel()).isPresent() ||
                    this.saleRepository.findById(deviceImportDto.getSaleId()).isEmpty() ||
                    !this.validationUtil.isValid(deviceImportDto)) {
                sb.append("Invalid device").append(System.lineSeparator());
                continue;
            }

            Device device = this.modelMapper.map(deviceImportDto, Device.class);
            device.setDeviceType(DeviceType.valueOf(deviceImportDto.getDeviceType()));
            device.setSale(this.saleRepository.findById(deviceImportDto.getSaleId()).get());

            this.deviceRepository.saveAndFlush(device);

            sb.append(String.format("Successfully imported device of type %s with brand %s",
                    deviceImportDto.getDeviceType(),
                    device.getBrand()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String exportDevices() {
        StringBuilder sb = new StringBuilder();

        this.deviceRepository
                .findByDeviceTypeAndPriceLessThanAndStorageGreaterThanEqualOrderByBrand(
                        DeviceType.SMART_PHONE, 1000, 128)
                .forEach(d -> {
                    sb.append(String.format("Device brand: %s\n" +
                            "   *Model: %s\n" +
                            "   **Storage: %d\n" +
                            "   ***Price: %.2f",
                            d.getBrand(), d.getModel(), d.getStorage(), d.getPrice()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
