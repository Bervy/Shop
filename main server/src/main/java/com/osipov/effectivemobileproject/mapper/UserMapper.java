package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.user.UserOutDto;
import com.osipov.effectivemobileproject.model.User;

public class UserMapper {

    public static UserOutDto userToDtoOut(User user) {
        return UserOutDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .balance(user.getBalance())
                .accountStatus(user.getAccountStatus())
                .build();
    }
}
