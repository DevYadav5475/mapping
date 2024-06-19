package com.demo.controller;

import com.demo.entity.Country;
import com.demo.entity.Employee;
import com.demo.repository.CountryRepository;
import com.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//{
//        "id": 1,
//        "name": "John Smith",
//        "addressLine": "456 Elm St",
//        "country": {
//        "id": 1,
//        "countryName": "India"
//        }
//        }

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private CountryRepository countryRepository;

    public EmployeeController(EmployeeRepository employeeRepository, CountryRepository countryRepository) {
        this.employeeRepository = employeeRepository;
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestParam long countryId,
            @RequestBody Employee employee){
        Employee savesEmp = employeeRepository.save(employee);
        Country country = countryRepository.findById(countryId).get();
        employee.setCountry(country);
        return ResponseEntity.ok().body(savesEmp);

    }
}
