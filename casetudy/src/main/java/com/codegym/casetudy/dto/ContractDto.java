package com.codegym.casetudy.dto;

import com.codegym.casetudy.model.customer.Customer;
import com.codegym.casetudy.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractDto implements Validator {

    private int id;
    private String startDate;
    private String endDate;
    private double deposit;
    private Customer customer;
    private Facility facility;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto customerDto = (ContractDto) target;
        try {
            Date startDate =new SimpleDateFormat("yyyy/MM/dd").parse( customerDto.getStartDate());
            Date endDate = new SimpleDateFormat("yyyy/MM/dd").parse(customerDto.getEndDate());
            if(startDate.compareTo(endDate)>0){
                errors.rejectValue("endDate", "endDate","ngày bắt đầu phải trước ngày kết thúc");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String deposit = String.valueOf(customerDto.getDeposit());
        if(!deposit.matches("^[1-9][0-9.]*$")){
            errors.rejectValue("deposit", "deposit","hãy nhập tiền cọc lớn hơn hoặc bằng 0");
        }



    }

    public ContractDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
