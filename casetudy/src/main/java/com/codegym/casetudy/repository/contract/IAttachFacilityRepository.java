package com.codegym.casetudy.repository.contract;

import com.codegym.casetudy.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select attach_facility.* from attach_facility\n" +
            "join contract_detail cd on attach_facility.id = cd.attach_facility_id\n" +
            "join contract c on c.id = cd.contract_id\n" +
            "where contract_id = ?",nativeQuery = true)
    List<AttachFacility> findAttachFacilityById(int id);
}
