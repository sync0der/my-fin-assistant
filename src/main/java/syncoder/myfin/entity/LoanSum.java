package syncoder.myfin.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanSum {
    private int minAmount;
    private int maxAmount;
}
