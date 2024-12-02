package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceImportRootDto {

    @XmlElement(name = "device")
    private List<DeviceImportDto> deviceImportDtos;

    public List<DeviceImportDto> getDeviceImportDtos() {
        return deviceImportDtos;
    }

    public void setDeviceImportDtos(List<DeviceImportDto> deviceImportDtos) {
        this.deviceImportDtos = deviceImportDtos;
    }
}
