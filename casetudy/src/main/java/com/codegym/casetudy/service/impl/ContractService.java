package com.codegym.casetudy.service.impl;


import com.codegym.casetudy.dto.IContractDto;
import com.codegym.casetudy.model.contract.AttachFacility;
import com.codegym.casetudy.model.contract.Contract;
import com.codegym.casetudy.model.contract.ContractDetail;
import com.codegym.casetudy.repository.contract.IAttachFacilityRepository;
import com.codegym.casetudy.repository.contract.IContractDetailRepository;
import com.codegym.casetudy.repository.contract.IContractRepository;
import com.codegym.casetudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<IContractDto> findAllContract() {
        return contractRepository.findAllContract();
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public List<AttachFacility> findAllAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void add(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<AttachFacility> findAttachFacilityById(int id) {
        return attachFacilityRepository.findAttachFacilityById(id);
    }


}
