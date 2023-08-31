package com.ordering.platform.dataaccess.adapter;

import com.ordering.platform.dataaccess.mapper.UserDataAccessMapper;
import com.ordering.platform.dataaccess.repository.UserJpaRepository;
import com.ordering.platform.user.service.domain.entity.User;
import com.ordering.platform.user.service.domain.ports.output.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserDataAccessMapper userDataAccessMapper;
    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserRepositoryImpl(UserDataAccessMapper userDataAccessMapper, UserJpaRepository userJpaRepository) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User createUser(User user) {
        return userDataAccessMapper.userEntityToUser(
                userJpaRepository.save(userDataAccessMapper.userToUserEntity(user)));
    }
}
