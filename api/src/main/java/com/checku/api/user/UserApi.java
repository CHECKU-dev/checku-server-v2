package com.checku.api.user;

import com.checku.api.user.request.UserCreateRequest;
import com.checku.api.user.response.UserCreateResponse;
import com.checku.api.user.response.UserResponse;
import com.checku.core.user.application.UserCommandService;
import com.checku.core.user.application.UserQueryService;
import com.checku.core.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserApi {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping
    public ResponseEntity<UserCreateResponse> create(@Valid @RequestBody final UserCreateRequest request) {
        User user = userCommandService.create(request.toCreateCommand());
        return ResponseEntity
                .created(URI.create("/api/users/" + user.getId()))
                .body(new UserCreateResponse(user.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable("id") final Long id) {
        User user = userQueryService.getById(id);
        return ResponseEntity
                .ok()
                .body(new UserResponse(user));
    }
}
