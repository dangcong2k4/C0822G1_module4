package com.example.exercise_1.dto;

import com.example.exercise_1.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {

    private int id;
    @NotBlank(message = "không đc để trống")
    @Size(min =5,max = 45,message = "tên đệm phải nhiều hơn 5 kí tự và ít hơn 45 ký tự")
    private String firstName;
    @Size(min =5,max = 45,message = "tên đệm phải nhiều hơn 5 kí tự và ít hơn 45 ký tự")
    private String lastName ;
    @Pattern(regexp = "^[0][0-9]{9}$",message = "hãy nhập số điện thoại bắt đầu từ số 0 và có 10 chữ số")
    private String phoneNumber;
    private int age;
    @Pattern(regexp = "^[a-z0-9]+[@][g][m][a][i][l][.][c][o][m]$",message = "hãy nhập gmail đúng định dạng có đuôi là '@gmail.com'")
    private String email;




    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        int age = userDto.getAge();
        if(age <18){
            errors.rejectValue("age", "age","bạn chưa đủ tuổi để đăng nhập");
        }
    }
    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
