package com.osipov.effectivemobileproject.service.private_part;

import com.osipov.effectivemobileproject.model.Notification;
import com.osipov.effectivemobileproject.model.User;

import java.util.List;

public interface PrivateUserService {
    User getUser(Long userId);

    List<Notification> findAllNotificationPage(Long userId, int from, int size);
}
