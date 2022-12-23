package com.codegym.exercise_2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {


    private int id;
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$",message = "Tên bài hát Không được chứa các kí tự đặc biệt")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    @NotBlank(message = "không đc để trống")
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$",message = "Tên bài hát Không được chứa các kí tự đặc biệt")
    @Size(max = 300, message = "Không vượt quá 300 ký tự")
    @NotBlank(message = "không đc để trống")
    private String artist;
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$",message = "Tên bài hát Không được chứa các kí tự đặc biệt")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    @NotBlank(message = "không đc để trống")
    private String category;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public SongDto() {
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
