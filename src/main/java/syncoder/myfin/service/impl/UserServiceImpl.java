package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.dto.UserDto;
import syncoder.myfin.dto.mapper.UserMapper;
import syncoder.myfin.entity.Card;
import syncoder.myfin.entity.User;
import syncoder.myfin.repository.UserRepository;
import syncoder.myfin.service.S3Service;
import syncoder.myfin.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final S3Service s3Service;

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        User user = userRepository.save(entity);
        return userMapper.toDto(user);
    }

    @Transactional
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        Optional.ofNullable(userDto.getFirstName()).ifPresent(user::setFirstName);
        Optional.ofNullable(userDto.getLastName()).ifPresent(user::setLastName);
        userRepository.save(user);
        return userMapper.toDto(user);

    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDto get(Long id) {
        return userMapper.toDto(userRepository.get(id));
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }


}
