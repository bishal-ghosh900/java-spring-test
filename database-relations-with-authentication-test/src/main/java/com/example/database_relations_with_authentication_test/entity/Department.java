package com.example.database_relations_with_authentication_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "department",
            targetEntity = Employee.class
    )
    @JsonIgnore
    private List<Employee> employee;

}
