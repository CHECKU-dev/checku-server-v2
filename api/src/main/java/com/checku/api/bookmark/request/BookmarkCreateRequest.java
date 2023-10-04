package com.checku.api.bookmark.request;

import com.checku.core.bookmark.domain.BookmarkCreateCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BookmarkCreateRequest {

    @NotBlank
    private String subjectNumber;

    public BookmarkCreateCommand toCreateCommand(Long userId) {
        return BookmarkCreateCommand.builder()
                .subjectNumber(subjectNumber)
                .userId(userId)
                .build();
    }
}
