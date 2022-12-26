package com.codegym.casetudy.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
@Entity
public class EducationDegree {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employees ;

    public EducationDegree() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
