package Philately.web.dto;

import Philately.stamp.model.Paper;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreateNewStampRequest {

    @NotNull
    @Size(min = 5, max = 20, message = "Name length must be between 5 and 20 characters!")
    private String name;

    @NotNull
    @Size(min = 5, max = 25, message = "Description length must be between 5 and 20 characters!")
    private String description;

    @NotNull
    @URL
    private String imageURL;

    @NotNull
    private Paper paper;
}
