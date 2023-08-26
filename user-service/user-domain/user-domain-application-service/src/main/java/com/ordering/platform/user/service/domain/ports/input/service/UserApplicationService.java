package com.ordering.platform.user.service.domain.ports.input.service;

import com.ordering.platform.user.service.domain.command.CreateUserCommand;
import com.ordering.platform.user.service.domain.response.CreateUserResponse;
import jakarta.validation.Valid;

public interface UserApplicationService {

    CreateUserResponse createUser (@Valid CreateUserCommand createUserCommand);
}
