package syncoder.myfin.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ExpensesCategory category;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
}
