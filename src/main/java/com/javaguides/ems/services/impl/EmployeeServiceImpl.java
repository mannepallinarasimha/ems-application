package com.javaguides.ems.services.impl;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.mapper.EmployeeMapper;
import com.javaguides.ems.models.Employee;
import com.javaguides.ems.repository.EmployeeRepository;
import com.javaguides.ems.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto)));
    }

    @Override
    public List<EmployeeDto> allEmployees() {
//       List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeDto> list = employees.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
        return employeeRepository.findAll().stream().map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee NOT Exists with id ::" + id));
        employee.setId(id);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setMobile(employeeDto.getMobile());
        employee.setEmail(employeeDto.getEmail());
//        Employee save = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee NOT Exists with id ::" + id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee NOT Exists with id ::" + id));
        employeeRepository.deleteById(employee.getId());
        return "Employee deleted successfully ::"+id;
    }
}
