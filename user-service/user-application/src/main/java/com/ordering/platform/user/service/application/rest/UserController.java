package com.ordering.platform.user.service.application.rest;

import com.ordering.platform.user.service.domain.command.CreateUserCommand;
import com.ordering.platform.user.service.domain.ports.input.service.UserApplicationService;
import com.ordering.platform.user.service.domain.response.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserCommand createUserCommand){
        return new ResponseEntity<>(userApplicationService.createUser(createUserCommand), HttpStatus.CREATED);
    }
}
