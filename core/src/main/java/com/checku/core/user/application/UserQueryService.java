package com.checku.core.user.application;

import com.checku.core.common.exception.EntityNotFoundException;
import com.checku.core.user.domain.User;
import com.checku.core.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryService {

    private final UserRepository userRepository;

    public User getById(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
