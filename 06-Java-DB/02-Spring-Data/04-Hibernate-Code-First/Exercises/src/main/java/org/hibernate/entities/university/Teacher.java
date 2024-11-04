package org.hibernate.entities.university;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Column
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    public Teacher() {
        super();
    }
}
