package com.codegym.casetudy.service;

import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.facility.Facility;
import com.codegym.casetudy.model.facility.FacilityType;
import com.codegym.casetudy.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    List<FacilityType> findFacilityTypeAll();

    List<RentType> findRentTypeAll();

    void save(Facility facility);

    void update(Facility facility);

    void delete(int id);

    Facility findById(int id);

    Page<Facility> searchFacility(String name, String FacilityType, Pageable pageable);
}
