package com.osipov.effectivemobileproject.service.private_part.impl;

import com.osipov.effectivemobileproject.error.NotFoundException;
import com.osipov.effectivemobileproject.model.Notification;
import com.osipov.effectivemobileproject.model.User;
import com.osipov.effectivemobileproject.repository.NotificationRepository;
import com.osipov.effectivemobileproject.repository.UserRepository;
import com.osipov.effectivemobileproject.service.private_part.PrivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.USER_NOT_FOUND;

@Service
@Transactional
public class PrivateUserServiceImpl implements PrivateUserService {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public PrivateUserServiceImpl(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public User getUser(final Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND.getTitle()));
    }

    @Override
    public List<Notification> findAllNotificationPage(final Long userId, final int from, final int size) {
        return notificationRepository.findAllByUserId(userId, PageRequest.of(from, size));
    }
}