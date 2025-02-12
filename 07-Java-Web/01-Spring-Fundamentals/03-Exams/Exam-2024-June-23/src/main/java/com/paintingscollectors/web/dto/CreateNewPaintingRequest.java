package com.paintingscollectors.web.dto;

import com.paintingscollectors.painting.model.Style;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreateNewPaintingRequest {

    @NotNull
    @Size(min = 5, max = 40, message = "Name length must be between 5 and 40 character!")
    private String name;

    @NotNull
    @Size(min = 5, max = 30, message = "Author length must be between 5 and 30 character!")
    private String author;

    @NotNull
    @URL(message = "Please enter valid image URL!")
    private String imageURL;

    @NotNull(message = "You must select a style!")
    private Style style;
}
