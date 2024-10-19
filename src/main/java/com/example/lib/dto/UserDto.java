package com.example.lib.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotBlank(message="User name is required")
    private String name;
    private  int phoneNumber;
    @NotBlank(message="email name is required")
    private String email;
    @NotBlank(message="address name is required")
    private String address;
    @NotNull
    private String branchCode;

}
