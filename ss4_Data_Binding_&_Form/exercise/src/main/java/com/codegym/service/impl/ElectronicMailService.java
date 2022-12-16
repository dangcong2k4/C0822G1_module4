package com.codegym.service.impl;

import com.codegym.model.ElectronicMail;
import com.codegym.repository.IElectronicMailRepository;
import com.codegym.repository.impl.ElectronicMailRepository;
import com.codegym.service.IElectronicMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicMailService implements IElectronicMailService {
    @Autowired
    private IElectronicMailRepository iConfigurationRepository;

    @Override
    public List<ElectronicMail> findAll() {
        return iConfigurationRepository.findAll();
    }

    @Override
    public void update(ElectronicMail configuration) {
        iConfigurationRepository.update(configuration);
    }

    @Override
    public ElectronicMail findIndexById(int id) {
        return iConfigurationRepository.findIndexById(id);
    }

    @Override
    public String[] listLanguage() {
        return iConfigurationRepository.listLanguage();
    }

    @Override
    public int[] listSize() {
        return iConfigurationRepository.listSize();
    }
}
