package com.example.bootstrap;

import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository repository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = repository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=======Region Test Start========================");
        System.out.println("repository.findByCountry(\"Canada\") = " + regionRepository.findByCountry("Canada"));
        System.out.println("repository.findDistinctByCountry(\"Canada\") = " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("repository.findDistinctByCountry(\"United States\") = " + regionRepository.findDistinctByCountry("United States"));
        System.out.println("repository.findByCountryContains(\"United\") = " + regionRepository.findByCountryContains("United"));
        System.out.println("repository.findByCountryContainsOrderByCountry(\"United\") = " + regionRepository.findByCountryContainsOrderByCountry("United"));
        System.out.println("repository.findTop2ByCountry(\"Canada\") = " + regionRepository.findTop2ByCountry("Canada"));
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

        System.out.println("=======EMPLOYEE Test End========================");

        System.out.println("=======COURSE Test Start========================");

        courseRepository.getCourses("Spring").forEach(System.out::println);
        System.out.println("=============================================");
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println("=============================================");
        System.out.println("courseRepository.existsByName(\"Java for All\") = " + courseRepository.existsByName("Java for All"));
        System.out.println("courseRepository.countCourseByCategory(\"Spring\") = " + courseRepository.countCourseByCategory("Spring"));
        System.out.println("=============================================");
        courseRepository.findAllByNameStartingWith("Getting").forEach(System.out::println);
        System.out.println("=============================================");
        courseRepository.streamByCategory("Spring").forEach(System.out::println);


        System.out.println("=======COURSE Test End========================");



    }
}
