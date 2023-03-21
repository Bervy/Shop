package com.osipov.effectivemobileproject.dto.user;

import com.osipov.effectivemobileproject.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOutDto {

    private String name;
    private String email;
    private String password;
    private Double balance;
    private AccountStatus accountStatus;
}