package com.osipov.effectivemobileproject.controller.private_part;

import com.osipov.effectivemobileproject.model.Notification;
import com.osipov.effectivemobileproject.service.private_part.PrivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{userId}")
public class PrivateUserController {

    private final PrivateUserService userService;

    @Autowired
    public PrivateUserController(PrivateUserService userService) {
        this.userService = userService;
    }

    @GetMapping("notification")
    public List<Notification> getHistoryByUser(
            @PathVariable(value = "userId") final Long userId,
            @RequestParam(defaultValue = "0") final int from,
            @RequestParam(defaultValue = "10") final int size
    ) {
        return userService.findAllNotificationPage(userId, from, size);
    }
}