package app.subscription.model;

import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private SubscriptionPeriod period;

    @Column
    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "renewal_allowed")
    private boolean renewalAllowed;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "completed_on", nullable = false)
    private LocalDateTime completedOn;

    @ManyToOne
    private User owner;
}
