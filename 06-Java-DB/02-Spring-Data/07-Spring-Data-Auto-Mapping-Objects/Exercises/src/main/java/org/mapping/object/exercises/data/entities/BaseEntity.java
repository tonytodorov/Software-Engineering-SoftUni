package org.mapping.object.exercises.data.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    protected BaseEntity() {}

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
