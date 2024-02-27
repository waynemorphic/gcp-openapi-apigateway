package org.example.employeedemo;

import com.example.employeeDemo.api.EmployeeApi;
import com.example.employeeDemo.model.EmployeeData;
import com.example.employeeDemo.model.HttpCreatedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<HttpCreatedResponse> createEmployee(EmployeeData employeeData) {
        employeeService.postEmployee(toEmployeeEntity(employeeData)); // b.
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<EmployeeData>> getEmployeeById(String employeeId) {
        List<EmployeeEntity> list = employeeService.getEmployeeById(Long.parseLong(employeeId));
        List<EmployeeData> listData = list.stream().map(data -> toEmployeeData(data)).collect(Collectors.toList()); // c.
        log.info("=====> Fetched an employee {}", listData.stream().toList());
        return new ResponseEntity<>(listData, HttpStatus.OK);
    }

    public EmployeeData toEmployeeData(EmployeeEntity employeeEntity){ // d.
        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployeeId(Integer.valueOf(String.valueOf(employeeEntity.getEmployeeId())));
        employeeData.setFirstName(employeeEntity.getFirstName());
        employeeData.setLastName(employeeEntity.getLastName());

        return employeeData;
    }

    public EmployeeEntity toEmployeeEntity(EmployeeData employeeData){ // e.
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(Long.valueOf(employeeData.getEmployeeId()));
        employeeEntity.setFirstName(employeeData.getFirstName());
        employeeEntity.setLastName(employeeData.getLastName());

        return employeeEntity;
    }
}
