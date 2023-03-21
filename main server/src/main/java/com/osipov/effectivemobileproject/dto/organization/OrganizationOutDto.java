package com.osipov.effectivemobileproject.dto.organization;

import com.osipov.effectivemobileproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationOutDto {

    private Long id;
    private String name;
    private String description;
    private URI logo;
    private User creator;
}