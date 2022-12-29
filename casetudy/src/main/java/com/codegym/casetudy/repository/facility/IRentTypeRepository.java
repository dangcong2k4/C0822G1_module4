package com.codegym.casetudy.repository.facility;

import com.codegym.casetudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
