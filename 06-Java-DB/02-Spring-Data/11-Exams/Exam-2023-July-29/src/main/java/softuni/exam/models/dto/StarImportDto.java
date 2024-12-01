package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;

public class StarImportDto {

    @Expose
    @Length(min = 6)
    private String description;

    @Expose
    @Positive
    private double lightYears;

    @Expose
    @Length(min = 2, max = 30)
    private String name;

    @Expose
    private String starType;

    @Expose
    private Long constellation;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLightYears() {
        return lightYears;
    }

    public void setLightYears(double lightYears) {
        this.lightYears = lightYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartType() {
        return starType;
    }

    public void setStartType(String startType) {
        this.starType = startType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
