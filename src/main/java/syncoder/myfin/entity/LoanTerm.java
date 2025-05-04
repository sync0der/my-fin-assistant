package syncoder.myfin.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanTerm {
    private int startTimeInMonths;
    private int endTimeInMonths;
}
