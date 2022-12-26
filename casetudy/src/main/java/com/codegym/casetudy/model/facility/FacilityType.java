package com.codegym.casetudy.model.facility;

import com.codegym.casetudy.model.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilities ;

    public FacilityType() {
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

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
