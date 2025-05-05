package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.dto.UserDto;
import syncoder.myfin.entity.Card;
import syncoder.myfin.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper implements MapperInterface<User, UserDto> {

    private final CardMapper cardMapper;

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();

        if (user.getCards() != null && !user.getCards().isEmpty()) {
            userDto.setCards((user.getCards().stream()
                    .map(cardMapper::toDto)
                    .collect(Collectors.toSet())));
        }
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }

}
