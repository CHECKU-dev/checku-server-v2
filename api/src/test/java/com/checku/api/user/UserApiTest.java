package com.checku.api.user;

import com.checku.api.user.request.UserCreateRequest;
import com.checku.api.user.response.UserCreateResponse;
import mock.ApiTestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class UserApiTest {

    @Test
    void UserCreateRequest로_유저를_생성할_수_있다() {
        // given
        ApiTestContainer apiTestContainer = new ApiTestContainer();

        // when
        ResponseEntity<UserCreateResponse> responseEntity = apiTestContainer.userApi.create(new UserCreateRequest("testToken"));

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
            softAssertions.assertThat(responseEntity.getHeaders().getFirst(HttpHeaders.LOCATION)).isEqualTo("/api/users/1");
            softAssertions.assertThat(responseEntity.getBody()).isNotNull();
            softAssertions.assertThat(responseEntity.getBody().getId()).isEqualTo(1L);
        });
    }
}
