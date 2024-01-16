package org.example.employeedemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void postEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getEmployeeById(Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }
}
