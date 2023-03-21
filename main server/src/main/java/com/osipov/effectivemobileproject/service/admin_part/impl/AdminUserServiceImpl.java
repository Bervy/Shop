package com.osipov.effectivemobileproject.service.admin_part.impl;

import com.osipov.effectivemobileproject.dto.notification.NotificationInDto;
import com.osipov.effectivemobileproject.dto.notification.NotificationOutDto;
import com.osipov.effectivemobileproject.dto.user.UserOutDto;
import com.osipov.effectivemobileproject.enums.AccountStatus;
import com.osipov.effectivemobileproject.error.NotFoundException;
import com.osipov.effectivemobileproject.mapper.NotificationMapper;
import com.osipov.effectivemobileproject.mapper.UserMapper;
import com.osipov.effectivemobileproject.model.User;
import com.osipov.effectivemobileproject.repository.NotificationRepository;
import com.osipov.effectivemobileproject.repository.UserRepository;
import com.osipov.effectivemobileproject.service.admin_part.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.USER_NOT_FOUND;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public AdminUserServiceImpl(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public UserOutDto raiseBalance(final Long userId, final Double balance) {
        User user = getUser(userId);
        userRepository.raiseBalance(userId, balance);
        return UserMapper.userToDtoOut(user);
    }

    @Override
    public NotificationOutDto sendNotification(final Long userId, final NotificationInDto notificationInDto) {
        User user = getUser(userId);
        notificationInDto.setUser(user);
        return NotificationMapper.notificationToDtoOut(
                notificationRepository.save(NotificationMapper.dtoInToNotification(notificationInDto)));
    }

    @Override
    public void userSetStatus(final Long userId, final AccountStatus accountStatus) {
        userRepository.userSetStatus(userId, accountStatus.toString());
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND.getTitle()));
    }
}