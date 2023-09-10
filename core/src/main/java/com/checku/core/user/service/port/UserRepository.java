package com.checku.core.user.service.port;

import com.checku.core.user.domain.User;

public interface UserRepository {

    User save(User user);
}
