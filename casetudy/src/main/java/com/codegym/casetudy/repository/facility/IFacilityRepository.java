package com.codegym.casetudy.repository.facility;

import com.codegym.casetudy.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
}
