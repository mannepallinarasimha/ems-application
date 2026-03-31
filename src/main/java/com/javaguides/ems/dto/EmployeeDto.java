package com.javaguides.ems.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String mobile;
    private String email;
}
