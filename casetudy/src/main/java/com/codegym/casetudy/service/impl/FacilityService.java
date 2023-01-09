package com.codegym.casetudy.service.impl;

import com.codegym.casetudy.model.facility.Facility;
import com.codegym.casetudy.model.facility.FacilityType;
import com.codegym.casetudy.model.facility.RentType;
import com.codegym.casetudy.repository.facility.IFacilityRepository;
import com.codegym.casetudy.repository.facility.IFacilityTypeRepository;
import com.codegym.casetudy.repository.facility.IRentTypeRepository;
import com.codegym.casetudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;


    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public List<FacilityType> findFacilityTypeAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> findRentTypeAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public Page<Facility> searchFacility(String name, String facilityType, Pageable pageable) {
        return facilityRepository.searchFacility(name,facilityType,pageable);
    }

    @Override
    public Page<Facility> searchFacilityName(String name, Pageable pageable) {
        return facilityRepository.searchFacilityName(name,pageable);
    }
}
