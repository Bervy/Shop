package com.osipov.effectivemobileproject.service.admin_part;


import com.osipov.effectivemobileproject.dto.notification.NotificationInDto;
import com.osipov.effectivemobileproject.dto.notification.NotificationOutDto;
import com.osipov.effectivemobileproject.dto.user.UserOutDto;
import com.osipov.effectivemobileproject.enums.AccountStatus;

public interface AdminUserService {
    UserOutDto raiseBalance(Long userId, Double balance);

    NotificationOutDto sendNotification(Long userId, NotificationInDto notificationInDto);

    void userSetStatus(Long userId, AccountStatus accountStatus);
}
