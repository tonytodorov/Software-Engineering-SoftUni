package org.mapping.object.exercises.service.dtos;

import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameEditDTO {

    private Integer id;

    @Length(min = 3, max = 100, message = "Title must be between 3 and 100 symbols")
    private String title;

    @Positive(message = "Price must be positive number")
    private BigDecimal price;

    @Positive(message = "Size must be positive number")
    private Double size;

    @Length(min = 11, max = 11, message = "Trailer must be 11 symbols length")
    private String trailer;

    private String imageThumbnail;

    @Length(min = 20, message = "Description must be at least 20 symbols")
    private String description;

    private LocalDate releaseDate;

    public GameEditDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
