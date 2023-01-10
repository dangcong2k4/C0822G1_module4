package com.codegym.casetudy.dto;

import com.codegym.casetudy.model.facility.FacilityType;
import com.codegym.casetudy.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FacilityDto implements Validator {
    private int id ;
    @NotBlank(message = "không đc để trống")
    @Size(min =5,max = 45,message = " họ tên phải nhiều hơn 5 kí tự và ít hơn 45 ký tự")
    private String name;
    @Pattern(regexp = "^[1-9][0-9]*$",message = "diện tích phải là số dương")
    private String area;
    @Pattern(regexp = "^[1-9][0-9.]*$",message = "chi phí thuê phải là số dương")
    private String cost;
    @Pattern(regexp = "^[1-9][0-9]*$",message = "số người phải nguyên dương")
    private String maxPeople;
    private String standardRoom;
    @Size(min =5,max = 45,message = " phải có mô tả cho dịch vụ này")
    private String descriptionOther;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
