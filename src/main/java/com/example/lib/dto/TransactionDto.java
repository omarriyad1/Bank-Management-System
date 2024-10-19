package com.example.lib.dto;

import com.example.lib.model.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class TransactionDto {
    @NotBlank(message = "Type is required")
    private String type;
    @NotNull
    @Min(value = 0, message = "amount of transaction cannot be under 0")
    private double amount;
    private Timestamp timestamp;
    @NotNull
    private Long account_Id;




}
