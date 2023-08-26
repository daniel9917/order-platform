package com.ordering.platform.user.service.domain.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserResponse {
    @NotNull
    private UUID userId;
    @NotNull
    private String message;
}
