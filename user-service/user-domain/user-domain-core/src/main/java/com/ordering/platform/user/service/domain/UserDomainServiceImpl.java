package com.ordering.platform.user.service.domain;

import com.ordering.platform.domain.exception.DomainException;
import com.ordering.platform.user.service.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserDomainServiceImpl implements UserDomainService {

    @Override
    public void validateUser(User user) throws DomainException {
        // validate user
        log.info("Restaurant with Id: {} has been initialized", user.getId());
    }
}
