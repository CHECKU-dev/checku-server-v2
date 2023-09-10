package com.checku.core.user.application;

import com.checku.core.user.domain.User;
import com.checku.core.user.domain.UserCreateCommand;
import com.checku.core.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommandService {

    private final UserRepository userRepository;

    public User create(UserCreateCommand userCreateCommand) {
        User user = User.create(userCreateCommand);
        return userRepository.save(user);
    }
}
