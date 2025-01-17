package app.transaction.model;

import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "balance_left", nullable = false)
    private BigDecimal balanceLeft;

    @Column
    private Currency currency;

    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column
    private String description;

    @Column
    private String failureReason;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @ManyToOne
    private User owner;
}
