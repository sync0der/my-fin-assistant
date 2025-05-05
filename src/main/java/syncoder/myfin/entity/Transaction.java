package syncoder.myfin.entity;

import jakarta.persistence.*;
import lombok.*;
import syncoder.myfin.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceNumber;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;

    private String description;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "sender_card_id")
    private Card senderCard;

    @ManyToOne
    @JoinColumn(name = "receiver_card_id")
    private Card receiverCard;

}
