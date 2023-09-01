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
                        createUserCommand.firstName(),
                        createUserCommand.lastName(),
                        createUserCommand.email(),
                        createUserCommand.address());
    }

    public CreateUserResponse userToCreateUserResponse(User user, String message) {
        return new CreateUserResponse.Builder()
                .userId(user.getId())
                .message("Successfully created user with Id: " + message)
                .build();
    }
}
