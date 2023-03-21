package com.osipov.effectivemobileproject.controller.admin_part;

import com.osipov.effectivemobileproject.dto.notification.NotificationInDto;
import com.osipov.effectivemobileproject.dto.notification.NotificationOutDto;
import com.osipov.effectivemobileproject.dto.user.UserOutDto;
import com.osipov.effectivemobileproject.enums.AccountStatus;
import com.osipov.effectivemobileproject.service.admin_part.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/user/{userId}")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @Autowired
    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @PatchMapping("balance")
    public UserOutDto raiseBalance(
            @PathVariable final Long userId,
            @RequestParam final Double balance
    ) {
        return adminUserService.raiseBalance(userId, balance);
    }

    @PostMapping("notification")
    public NotificationOutDto sendNotification(
            @PathVariable final Long userId,
            @RequestBody final NotificationInDto notificationInDto
    ) {
        return adminUserService.sendNotification(userId, notificationInDto);
    }

    @PatchMapping()
    public void userSetStatus(
            @PathVariable final Long userId,
            @RequestParam final AccountStatus accountStatus
    ) {
        adminUserService.userSetStatus(userId, accountStatus);
    }
}