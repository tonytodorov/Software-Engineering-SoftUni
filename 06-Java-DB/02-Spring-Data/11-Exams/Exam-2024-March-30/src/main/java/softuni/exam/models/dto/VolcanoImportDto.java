package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

public class VolcanoImportDto {

    @Expose
    @Length(min = 2, max = 30)
    private String name;

    @Expose
    @Min(0)
    private double elevation;

    @Expose
    private String volcanoType;

    @Expose
    private boolean isActive;

    @Expose
    private String lastEruption;

    @Expose
    private int country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getVolcanoType() {
        return volcanoType;
    }

    public void setVolcanoType(String volcanoType) {
        this.volcanoType = volcanoType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastEruption() {
        return lastEruption;
    }

    public void setLastEruption(String lastEruption) {
        this.lastEruption = lastEruption;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}
