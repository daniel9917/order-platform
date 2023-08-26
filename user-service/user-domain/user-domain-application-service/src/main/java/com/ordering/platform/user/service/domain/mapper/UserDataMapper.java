package com.ordering.platform.user.service.domain.mapper;

import com.ordering.platform.user.service.domain.command.CreateUserCommand;
import com.ordering.platform.user.service.domain.entity.User;
import com.ordering.platform.user.service.domain.response.CreateUserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public User createUserCommandToUser (CreateUserCommand createUserCommand) {
        return
                new User(
                        createUserCommand.getId(),
                        createUserCommand.getFirstName(),
                        createUserCommand.getLastName(),
                        createUserCommand.getEmail(),
                        createUserCommand.getAddress());
    }

    public CreateUserResponse userToCreateUserResponse(User user, String message) {
        return CreateUserResponse.builder()
                .userId(user.getId())
                .message(message)
                .build();
    }
}
