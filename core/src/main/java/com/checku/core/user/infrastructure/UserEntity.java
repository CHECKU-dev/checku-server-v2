package com.checku.core.user.infrastructure;

import com.checku.core.common.infrastructure.BaseTimeEntity;
import com.checku.core.user.domain.User;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "push_token")
    private String pushToken;

    public User toModel() {
        return User.builder()
                .id(id)
                .pushToken(pushToken)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public static UserEntity from(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = user.getId();
        userEntity.pushToken = user.getPushToken();
        userEntity.createdAt = user.getCreatedAt();
        userEntity.updatedAt = user.getUpdatedAt();
        return userEntity;
    }
}
