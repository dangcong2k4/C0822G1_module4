package com.codegym.casetudy.repository.contract;

import com.codegym.casetudy.model.contract.AttachFacility;
import com.codegym.casetudy.model.contract.Contract;
import com.codegym.casetudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

}
