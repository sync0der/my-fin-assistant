package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.entity.Card;

@Component
@RequiredArgsConstructor
public class CardMapper implements MapperInterface<Card, CardDto> {


    private final ExpensesMapper expensesMapper;

    @Override
    public CardDto toDto(Card card) {
        CardDto cardDto = CardDto.builder()
                .id(card.getId())
                .cardType(card.getCardType())
                .cardNumber(card.getCardNumber())
                .build();
        if (card.getExpenses() != null && !card.getExpenses().isEmpty()) {
            cardDto.setExpenses(card.getExpenses().stream().map(expensesMapper::toDto).toList());
        }

        return cardDto;
    }

    @Override
    public Card toEntity(CardDto cardDto) {
        return Card.builder()
                .cardType(cardDto.getCardType())
                .cardNumber(cardDto.getCardNumber())
                .build();
    }
}
