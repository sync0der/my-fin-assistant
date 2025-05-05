package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;
import syncoder.myfin.entity.enums.CardType;

@Data
@Builder
public class CardDto {
    private Long id;
    private CardType cardType;
    private String cardNumber;
}
