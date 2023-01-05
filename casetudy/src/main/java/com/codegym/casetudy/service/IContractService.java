package com.codegym.casetudy.service;

import com.codegym.casetudy.model.contract.AttachFacility;
import com.codegym.casetudy.model.contract.Contract;
import com.codegym.casetudy.model.contract.ContractDetail;
import com.codegym.casetudy.model.facility.Facility;

import java.util.List;

public interface IContractService {
    List<Contract> findAllContract();

    List<Contract> findAll();

    List<AttachFacility> findAllAttachFacility();

    void save(Contract contract);

    void add(ContractDetail contractDetail);

    void update(Contract contract);

    List<AttachFacility> findAttachFacilityById(int id);
}
