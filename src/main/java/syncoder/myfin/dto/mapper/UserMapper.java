package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.dto.UserDto;
import syncoder.myfin.entity.Card;
import syncoder.myfin.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper implements MapperInterface<User, UserDto> {

    private final CardMapper cardMapper;
    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .cards(user.getCards().stream()
                        .map(cardMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) return null;
        User user = User.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .cards(dto.getCards().stream()
                        .map(cardDto -> new Card(cardDto.getId(), cardDto.getCardType(), cardDto.getCardNumber())) // This now works
                        .collect(Collectors.toList()))
                .build();
        user.getCards().forEach(card -> card.setUser(user));

        return user;
    }
}
