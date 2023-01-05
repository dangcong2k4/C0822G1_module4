package com.codegym.casetudy.dto;

import com.codegym.casetudy.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CustomerDto implements Validator {
    private int id;
    @NotBlank(message = "không đc để trống")
    @Size(min =5,max = 45,message = " họ tên phải nhiều hơn 5 kí tự và ít hơn 45 ký tự")
    private String name;
    @Pattern(regexp = "^\\d{1,2}-\\d{1,2}-\\d{4}$",message = "hãy nhập số điện thoại bắt đầu từ số 0 và có 10 chữ số")
    private String dateOfBirth;
    private Boolean gender;
    @Pattern(regexp = "^[0-9]{12}$",message = "hãy nhập số thẻ CCCD có 12 chữ số")
    private String idCard;
    @Pattern(regexp = "^[0][0-9]{9}$",message = "hãy nhập số điện thoại bắt đầu từ số 0 và có 10 chữ số")
    private String phoneNumber;
    @Pattern(regexp = "^[a-z0-9]+[@][g][m][a][i][l][.][c][o][m]$",message = "hãy nhập gmail đúng định dạng có đuôi là '@gmail.com'")
    private String email;
    private String address;
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
