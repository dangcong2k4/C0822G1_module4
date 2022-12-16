package com.codegym.repository.impl;

import com.codegym.model.ElectronicMail;
import com.codegym.repository.IElectronicMailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ElectronicMailRepository implements IElectronicMailRepository {
    private String[] language = {"English","Vietnamese","Japanese" , "Chinese"};
    private int[] size = {5, 10, 15, 25, 50, 100 };
    private static List<ElectronicMail> configurationList ;

    static {
        configurationList = new ArrayList<>();
        configurationList.add(new ElectronicMail(1,"English",25,true,"công"));
        configurationList.add(new ElectronicMail(2,"Vietnamese",10,false,"công"));
    }
    @Override
    public List<ElectronicMail> findAll() {
        return configurationList;
    }

    @Override
    public void update(ElectronicMail configuration) {
        for (ElectronicMail x: configurationList) {
            if (x.getId() == configuration.getId()) {
                x.setLanguages(configuration.getLanguages());
                x.setPageSize(configuration.getPageSize());
                x.setSignature(configuration.getSignature());
                x.setSpamsFilter(configuration.isSpamsFilter());
            }
        }
    }

    @Override
    public ElectronicMail findIndexById(int id) {
        for (ElectronicMail x: configurationList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    @Override
    public String[] listLanguage() {
        return this.language;
    }

    @Override
    public int[] listSize() {
        return this.size;
    }
}
