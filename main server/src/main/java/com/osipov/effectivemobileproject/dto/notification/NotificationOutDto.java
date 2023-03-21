package com.osipov.effectivemobileproject.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationOutDto {
    private String header;
    private String text;
    private Timestamp createTime;
}