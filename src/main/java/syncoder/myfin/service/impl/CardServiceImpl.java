package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.dto.mapper.CardMapper;
import syncoder.myfin.entity.Card;
import syncoder.myfin.repository.CardRepository;
import syncoder.myfin.service.CardService;
import syncoder.myfin.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final UserService userService;

    @Override
    public CardDto createCard(Long userId, CardDto cardDto) {
        Card entity = cardMapper.toEntity(cardDto);
        entity.setUser(userService.getUser(userId));
        Card savedCard = cardRepository.save(entity);
        return cardMapper.toDto(savedCard);
    }

    @Override
    public CardDto updateCard(CardDto cardDto) {
        Card entity = cardMapper.toEntity(cardDto);
        Optional.ofNullable(cardDto.getCardNumber()).ifPresent(entity::setCardNumber);
        Optional.ofNullable(cardDto.getCardType()).ifPresent(entity::setCardType);
        cardRepository.save(entity);
        return cardMapper.toDto(entity);


    }

    @Override
    public void deleteCard(CardDto cardDto) {
        cardRepository.delete(cardMapper.toEntity(cardDto));
    }

    @Override
    public CardDto getCard(CardDto cardDto) {
        return cardRepository.findById(String.valueOf(cardDto.getId()))
                .map(cardMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Card not found"));

    }

    @Override
    public List<CardDto> getCards() {
        return cardRepository.findAll().stream().map(cardMapper::toDto).toList();
    }
}
