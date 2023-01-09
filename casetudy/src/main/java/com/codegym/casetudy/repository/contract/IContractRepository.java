package com.codegym.casetudy.repository.contract;

import com.codegym.casetudy.dto.IContractDto;
import com.codegym.casetudy.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select\n" +
            "       `contract`.id as id,`facility`.name as facilityName, `customer`.name as customerName,\n" +
            "       `contract`.start_date as startDate,`contract`.end_date as endDate,\n" +
            "       `contract`.deposit as deposit,`customer`.id as customerId, `facility`.id as facilityId,\n" +
            "       (ifnull(`facility`.cost,0)+sum(ifnull(`contract_detail`.quantity,0))*ifnull(`attach_facility`.cost,0)) as totalMoney\n" +
            "from `contract`\n" +
            "         left join `customer` on `contract`.customer_id = `customer`.id\n" +
            "         left join `facility` on `facility`.id= `contract`.facility_id\n" +
            "         left join `contract_detail` on `contract_detail`.contract_id = contract.id\n" +
            "         left join `attach_facility` on `attach_facility`.id = `contract_detail`.attach_facility_id\n" +
            "group by `contract`.id,`customer`.id\n" +
            "order by `customer`.id \n"
            ,nativeQuery = true)
    List<IContractDto> findAllContract();
}
