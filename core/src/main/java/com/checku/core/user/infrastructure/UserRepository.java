package com.checku.core.user.infrastructure;

import com.checku.core.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface UserRepository {

    User save(User user);

    @Repository
    @RequiredArgsConstructor
    class Default implements UserRepository {

        private final UserJpaRepository userJpaRepository;

        @Override
        public User save(User user) {
            return userJpaRepository.save(UserEntity.from(user)).toModel();
        }
    }
}
