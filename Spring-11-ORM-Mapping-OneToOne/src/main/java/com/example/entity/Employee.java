package com.example.entity;

import com.example.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    private int salary;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_ID")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    private Region region;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, int salary, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.gender = gender;
    }
}
