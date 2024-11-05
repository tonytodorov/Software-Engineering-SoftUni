package org.hibernate.entites.composition;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "batches")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String serial;

    @OneToMany(mappedBy = "batch", targetEntity = Shampoo.class)
    private Set<Shampoo> shampoo;

    public Batch() {
        this.shampoo = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Set<Shampoo> getShampoo() {
        return shampoo;
    }

    public void setShampoo(Shampoo shampoo) {
        this.shampoo.add(shampoo);
    }
}
