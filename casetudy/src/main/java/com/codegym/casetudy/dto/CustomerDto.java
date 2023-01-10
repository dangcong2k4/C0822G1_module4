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
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+[A-Z][a-z]+$",message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa. ")
    private String name;
    @Pattern(regexp = "^\\d{4}-\\d{1,2}-\\d{1,2}$",message = "hãy nhập đúng định dạng của ngày tháng năm")
    private String dateOfBirth;
    private Boolean gender;
    private String idCard;
    private String phoneNumber;
    @Pattern(regexp = "^[a-z0-9]+@gmail.com$",message = "hãy nhập gmail đúng định dạng có đuôi là '@gmail.com'")
    private String email;
    private String address;
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String idCard = customerDto.getIdCard();
        if(!idCard.matches("[0-9]{12}") && !idCard.matches("[0-9]{9}")){
            errors.rejectValue("idCard", "idCard","hãy nhập CMND với 9 số, hoặc nhập CCCD với 12 số ");
        }
        String phoneNumber = customerDto.getPhoneNumber();
        if(!phoneNumber.matches("^09[01][\\d]{7}$") && !phoneNumber.matches("^(84)+9[01][\\d]{7}$")){
            errors.rejectValue("phoneNumber", "phoneNumber","3.\tSố điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx. ");
        }
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
