package org.hibernate.entites.composition;

import jakarta.persistence.*;

@Entity
@Table(name = "labels")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String title;

    @Basic
    private String subtitle;

    @OneToOne(mappedBy = "label", targetEntity = Shampoo.class)
    private Shampoo shampoo;

    public Label() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Shampoo getShampoo() {
        return shampoo;
    }

    public void setShampoo(Shampoo shampoo) {
        this.shampoo = shampoo;
    }

}
