package com.example.lib.dto;

import com.example.lib.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AccountDto {


    @NotNull
    @Min(value = 0, message = "your balance cannot be under 0")
    private double balance;
    @NotBlank(message = "AccountType is required")
    private String accountType;
    @NotNull
    private int userId;
}
