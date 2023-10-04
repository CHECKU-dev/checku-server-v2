package com.checku.core.common.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public abstract class BaseTime {

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;
}
