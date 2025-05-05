package syncoder.myfin.entity;


import jakarta.persistence.*;
import lombok.*;
import syncoder.myfin.entity.enums.CardType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

