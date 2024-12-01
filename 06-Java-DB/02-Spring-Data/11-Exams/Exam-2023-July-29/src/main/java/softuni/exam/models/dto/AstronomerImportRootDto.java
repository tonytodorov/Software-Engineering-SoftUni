package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportRootDto {

    @XmlElement(name = "astronomer")
    private List<AstronomerImportDto> astronomersImportDtos;

    public List<AstronomerImportDto> getAstronomersImportDtos() {
        return astronomersImportDtos;
    }

    public void setAstronomersImportDtos(List<AstronomerImportDto> astronomersImportDtos) {
        this.astronomersImportDtos = astronomersImportDtos;
    }
}
