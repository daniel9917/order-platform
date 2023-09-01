package com.ordering.platform.user.service.domain.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

public record CreateUserResponse (UUID userId, String message){

    public static final class Builder {
        private UUID userId;
        private String message;

        public Builder userId (UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder message (String message) {
            this.message = message;
            return this;
        }

        public CreateUserResponse build () {
            return new CreateUserResponse(userId, message);
        }
    }
}
