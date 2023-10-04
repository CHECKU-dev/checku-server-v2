package com.checku.core.user.infrastructure;

import com.checku.core.user.domain.User;
import com.checku.core.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(final User user) {
        return userJpaRepository.save(UserEntity.from(user)).toModel();
    }

    @Override
    public Optional<User> findById(final Long id) {
        return userJpaRepository.findById(id)
                .map(UserEntity::toModel);
    }
}
