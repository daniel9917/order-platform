package com.ordering.platform.user.service.domain;

import com.ordering.platform.user.service.domain.command.CreateUserCommand;
import com.ordering.platform.user.service.domain.entity.User;
import com.ordering.platform.user.service.domain.exception.UserDomainException;
import com.ordering.platform.user.service.domain.mapper.UserDataMapper;
import com.ordering.platform.user.service.domain.ports.input.service.UserApplicationService;
import com.ordering.platform.user.service.domain.ports.output.repository.UserRepository;
import com.ordering.platform.user.service.domain.response.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@AllArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserDomainService userDomainService;
    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;


    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        User mappedUser = userDataMapper.createUserCommandToUser(createUserCommand);
        userDomainService.validateUser(mappedUser);
        User persistedUser = userRepository.createUser(mappedUser);
        if (persistedUser == null) {
            log.error("Unable to create user with Id: {}", createUserCommand.getId());
            throw new UserDomainException("Unable to create user with Id: " + createUserCommand.getId());
        }
        log.info("Successfully created user with id: {}", createUserCommand.getId());
        return userDataMapper.userToCreateUserResponse(persistedUser, persistedUser.getId().toString());
    }
}
