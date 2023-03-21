package com.osipov.effectivemobileproject.dto.notification;

import com.osipov.effectivemobileproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationInDto {

    private String header;
    private String text;
    private Timestamp createTime = Timestamp.from(Instant.now());
    private User user;
}