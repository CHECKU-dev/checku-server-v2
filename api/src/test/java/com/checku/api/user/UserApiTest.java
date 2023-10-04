package com.checku.api.user;

import com.checku.api.user.request.UserCreateRequest;
import com.checku.api.user.response.UserCreateResponse;
import com.checku.api.user.response.UserResponse;
import mock.ApiTestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class UserApiTest {

    private final ApiTestContainer apiTestContainer = new ApiTestContainer();
    private final UserApi userApi = apiTestContainer.userApi;

    @Test
    void UserCreateRequest로_유저를_생성할_수_있다() {
        // when
        ResponseEntity<UserCreateResponse> responseEntity = userApi.create(new UserCreateRequest("testToken"));

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
            softAssertions.assertThat(responseEntity.getHeaders().getFirst(HttpHeaders.LOCATION)).isEqualTo("/api/users/1");
            softAssertions.assertThat(responseEntity.getBody()).isNotNull();
            softAssertions.assertThat(responseEntity.getBody().getId()).isEqualTo(1L);
        });
    }

    @Test
    void Id로_User정보를_조회할_수_있다() {
        //given
        String token = "testToken";
        Long id = 1L;
        userApi.create(new UserCreateRequest(token));

        // when
        ResponseEntity<UserResponse> responseEntity = userApi.get(id);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
            softAssertions.assertThat(responseEntity.getBody()).isNotNull();
            softAssertions.assertThat(responseEntity.getBody().getId()).isEqualTo(id);
            softAssertions.assertThat(responseEntity.getBody().getPushToken()).isEqualTo(token);
        });
    }
}
