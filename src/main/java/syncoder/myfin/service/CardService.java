package syncoder.myfin.service;

import syncoder.myfin.dto.CardDto;

import java.util.List;

public interface CardService {
    CardDto createCard(Long userId, CardDto cardDto);

    CardDto updateCard(CardDto cardDto);

    void deleteCard(CardDto cardDto);

    CardDto getCard(CardDto cardDto);

    List<CardDto> getCards();

}
