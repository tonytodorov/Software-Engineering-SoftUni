package com.paintingscollectors.painting.model;


import com.paintingscollectors.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FavouritePainting {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private LocalDateTime createdOn;
}
