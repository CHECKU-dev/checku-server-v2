package com.checku.core.user.service.port;

import com.checku.core.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(final User user);

    Optional<User> findById(final Long id);
}
