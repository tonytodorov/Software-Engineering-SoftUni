package spring.introduction.lab.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private BigDecimal balance;


    public Account() {}

    public Account(BigDecimal balance) {
        this.balance = balance;
    }
}
