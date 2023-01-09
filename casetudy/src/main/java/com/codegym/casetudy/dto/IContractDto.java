package com.codegym.casetudy.dto;

public interface IContractDto {
    int getId();
    String getFacilityName();
    String getCustomerName();
    String getStartDate();
    String getEndDate();
    double getDeposit();
    double getTotalMoney();
    int getCustomerId();
    int getFacilityId();
}
