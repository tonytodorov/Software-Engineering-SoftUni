package org.hibernate.entites.composition;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shampoos")
public class Shampoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String brand;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Label label;

    @ManyToOne
    private Batch batch;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id")
//            inverseJoinColumns = @JoinColumn
    )
    private List<Ingredient> ingredients;

    public Shampoo() {
        this.ingredients = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
