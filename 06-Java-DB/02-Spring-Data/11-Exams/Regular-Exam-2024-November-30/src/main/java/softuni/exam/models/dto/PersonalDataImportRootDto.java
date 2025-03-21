package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "personal_datas")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataImportRootDto {

    @XmlElement(name = "personal_data")
    private List<PersonalDataImportDto> personalDataImportDtos;

    public List<PersonalDataImportDto> getPersonalDataImportDtos() {
        return personalDataImportDtos;
    }

    public void setPersonalDataImportDtos(List<PersonalDataImportDto> personalDataImportDtos) {
        this.personalDataImportDtos = personalDataImportDtos;
    }
}
