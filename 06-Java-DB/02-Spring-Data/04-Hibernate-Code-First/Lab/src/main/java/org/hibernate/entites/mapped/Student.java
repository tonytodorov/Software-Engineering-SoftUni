package org.hibernate.entites.mapped;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.entites.IdEntity;

@Entity
@Table(name = "students")
public class Student extends IdEntity {

    @Column(name = "average_grade")
    private double averageGrade;

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
