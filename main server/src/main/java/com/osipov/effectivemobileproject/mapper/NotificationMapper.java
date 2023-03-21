package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.notification.NotificationInDto;
import com.osipov.effectivemobileproject.dto.notification.NotificationOutDto;
import com.osipov.effectivemobileproject.model.Notification;

public class NotificationMapper {

    public static Notification dtoInToNotification(NotificationInDto notificationInDto) {
        return Notification.builder()
                .header(notificationInDto.getHeader())
                .text(notificationInDto.getText())
                .build();
    }

    public static NotificationOutDto notificationToDtoOut(Notification notification) {
        return NotificationOutDto.builder()
                .header(notification.getHeader())
                .text(notification.getText())
                .build();
    }
}