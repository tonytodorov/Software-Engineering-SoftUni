package softuni.exam.models.entity;

import softuni.exam.models.enums.StarType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "light_years", nullable = false)
    private double lightYears;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "star_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StarType starType;

    @ManyToOne
    @JoinColumn(name = "constellation_id", referencedColumnName = "id")
    private Constellation constellation;

    @OneToMany(mappedBy = "observingStar", fetch = FetchType.EAGER)
    private Set<Astronomer> astronomers;

    public Star() {
        this.astronomers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLightYears() {
        return lightYears;
    }

    public void setLightYears(double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Set<Astronomer> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(Set<Astronomer> astronomers) {
        this.astronomers = astronomers;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }
}
