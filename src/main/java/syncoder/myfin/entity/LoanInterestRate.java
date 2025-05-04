package syncoder.myfin.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanInterestRate {
    private float minRate;
    private float maxRate;
    private String interestPaymentTerms;
}
