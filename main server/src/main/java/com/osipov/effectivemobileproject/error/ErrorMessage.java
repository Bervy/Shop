package com.osipov.effectivemobileproject.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorMessage {
    private String errors;
    private String message;
    private String reason;
    private String status;
    private String timestamp;
}