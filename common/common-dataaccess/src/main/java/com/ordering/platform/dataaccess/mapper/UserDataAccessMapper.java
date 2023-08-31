package com.ordering.platform.dataaccess.mapper;

import com.ordering.platform.dataaccess.entity.UserEntity;
import com.ordering.platform.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {
    public User userEntityToUser (UserEntity userEntity) {
        return
                new User(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getEmail(),
                        userEntity.getAddress()
                );
    }

    public UserEntity userToUserEntity (User user){
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress())
                .build();
    }
}
