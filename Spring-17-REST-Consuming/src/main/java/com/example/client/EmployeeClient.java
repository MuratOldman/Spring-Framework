package com.example.client;

import com.example.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "https://dummyapi.io",name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    @GetMapping("/data/v1/user?limit=10")
    List<Employee> getAllEmployees();

    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee(@RequestHeader ("app-id") String id);
}
