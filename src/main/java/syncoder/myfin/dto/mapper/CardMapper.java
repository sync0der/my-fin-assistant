package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.entity.Card;

@Component
@RequiredArgsConstructor
public class CardMapper implements MapperInterface<Card, CardDto> {


    @Override
    public CardDto toDto(Card card) {
        return CardDto.builder()
                .id(card.getId())
                .cardType(card.getCardType())
                .cardNumber(card.getCardNumber())
                .build();
    }

    @Override
    public Card toEntity(CardDto cardDto) {
        return Card.builder()
                .id(cardDto.getId())
                .cardType(cardDto.getCardType())
                .cardNumber(cardDto.getCardNumber())
                .build();
    }
}
