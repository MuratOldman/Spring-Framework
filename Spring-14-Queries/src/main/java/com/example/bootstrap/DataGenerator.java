package com.example.bootstrap;

import com.example.entity.Region;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository repository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository repository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=======Region Test Start========================");
        System.out.println("repository.findByCountry(\"Canada\") = " + repository.findByCountry("Canada"));
        System.out.println("repository.findDistinctByCountry(\"Canada\") = " + repository.findDistinctByCountry("Canada"));
        System.out.println("repository.findDistinctByCountry(\"United States\") = " + repository.findDistinctByCountry("United States"));
        System.out.println("repository.findByCountryContains(\"United\") = " + repository.findByCountryContains("United"));
        System.out.println("repository.findByCountryContainsOrderByCountry(\"United\") = " + repository.findByCountryContainsOrderByCountry("United"));
        System.out.println("repository.findTop2ByCountry(\"Canada\") = " + repository.findTop2ByCountry("Canada"));
        System.out.println("=======Region Test End========================");

        System.out.println("=======DEPARTMENT Test Start========================");
        System.out.println("departmentRepository.findByDepartment(\"Furniture\") = " + departmentRepository.findByDepartment("Furniture"));
        departmentRepository.findByDivisionIs("Health");
        System.out.println("departmentRepository.findByDivisionIs(\"Health\")" + departmentRepository.findByDivisionIs("Health"));
        System.out.println("departmentRepository.findDistinctTop3ByDivisionContains(\"Hea\")" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("=======DEPARTMENT Test End========================");

        System.out.println("=======EMPLOYEE Test Start========================");
        System.out.println("employeeRepository.getEmployeeDetail()  = " + employeeRepository.getEmployeeDetail() );
        System.out.println("employeeRepository.getEmployeeSalary() = " + employeeRepository.getEmployeeSalary());
        System.out.println("employeeRepository.getEmployeeDetail(\"sdubber7@t-online.de\") = " + employeeRepository.getEmployeeDetail("sdubber7@t-online.de"));

        System.out.println("=======EMPLOYEE Test Start========================");



    }
}
