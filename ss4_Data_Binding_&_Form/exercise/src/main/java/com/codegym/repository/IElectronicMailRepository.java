package com.codegym.repository;

import com.codegym.model.ElectronicMail;

import java.util.List;

public interface IElectronicMailRepository {
    List<ElectronicMail> findAll();

    void update(ElectronicMail configuration);

    ElectronicMail findIndexById(int id);

    String[] listLanguage();

    int[] listSize();
}
