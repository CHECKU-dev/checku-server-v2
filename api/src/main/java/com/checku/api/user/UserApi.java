package com.checku.api.user;

import com.checku.api.user.request.UserCreateRequest;
import com.checku.api.user.response.UserCreateResponse;
import com.checku.core.user.application.UserCommandService;
import com.checku.core.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserApi {

    private final UserCommandService userCommandService;

    @PostMapping
    public ResponseEntity<UserCreateResponse> create(@Valid @RequestBody final UserCreateRequest request) {
        User user = userCommandService.create(request.toCreateCommand());
        return ResponseEntity
                .created(URI.create("/api/users/" + user.getId()))
                .body(new UserCreateResponse(user.getId()));
    }
}
