package syncoder.myfin.service;

import syncoder.myfin.dto.CardDto;
import syncoder.myfin.dto.UserDto;
import syncoder.myfin.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    User getUser(Long id);

    UserDto get(Long id);

    List<UserDto> getUsers();

}

