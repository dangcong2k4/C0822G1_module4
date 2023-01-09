package com.codegym.casetudy.repository.facility;

import com.codegym.casetudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select `facility`.* from `facility`" +
            " join `facility_type` on `facility_type`.id = `facility`.facility_type_id " +
            "where `facility`.name like concat('%',:name,'%') and `facility_type`.name = :facilityType",nativeQuery = true)
    Page<Facility> searchFacility(@Param("name") String name,
                                  @Param("facilityType") String facilityType,
                                  Pageable pageable);
    @Query(value = "select `facility`.* from `facility`" +
            " join `facility_type` on `facility_type`.id = `facility`.facility_type_id " +
            "where `facility`.name like concat('%',:name,'%')",nativeQuery = true)
    Page<Facility> searchFacilityName(@Param("name") String name,
                                  Pageable pageable);
}
