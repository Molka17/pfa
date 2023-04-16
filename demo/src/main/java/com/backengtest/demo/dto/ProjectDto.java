package com.backengtest.demo.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private double payment;
    private Boolean active;
    private Date date;
    private Long projectDomainId;
}
