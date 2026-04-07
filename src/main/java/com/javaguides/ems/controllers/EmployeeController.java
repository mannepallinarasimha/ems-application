package com.javaguides.ems.controllers;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.models.Employee;
import com.javaguides.ems.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
//@RequestMapping(path = "api/v1/ems")
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping("/")
    public String healthCheck() {
        return "OK...";
    }

    @PostMapping(path="create-employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping(path="all-employees")
    public ResponseEntity<List<EmployeeDto>> allEmployees(){
        return new ResponseEntity<>(employeeService.allEmployees(), HttpStatus.OK);
    }

    @PutMapping(path="update-employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDto), HttpStatus.OK);
    }

    @GetMapping(path="get-employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping(path="delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }


}
