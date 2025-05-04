package syncoder.myfin.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRates {
    private String currency;
    private double toBuy;
    private double toSell;
}
