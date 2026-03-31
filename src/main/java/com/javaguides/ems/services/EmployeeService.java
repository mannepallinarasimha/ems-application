package com.javaguides.ems.services;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.models.Employee;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> allEmployees();

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    String deleteEmployee(Long id);
}
