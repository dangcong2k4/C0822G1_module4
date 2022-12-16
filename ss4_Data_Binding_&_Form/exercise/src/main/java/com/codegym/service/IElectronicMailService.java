package com.codegym.service;

import com.codegym.model.ElectronicMail;

import java.util.List;

public interface IElectronicMailService {
    List<ElectronicMail> findAll();

    void update(ElectronicMail configuration);

    ElectronicMail findIndexById(int id);

    String[] listLanguage();

    int[] listSize();
}
