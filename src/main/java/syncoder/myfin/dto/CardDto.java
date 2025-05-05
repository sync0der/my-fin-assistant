package syncoder.myfin.dto;

import lombok.Builder;
import lombok.Data;
import syncoder.myfin.entity.enums.CardType;

import java.util.List;

@Data
@Builder
public class CardDto {
    private Long id;
    private CardType cardType;
    private String cardNumber;
    private List<ExpensesDto> expenses;
}
