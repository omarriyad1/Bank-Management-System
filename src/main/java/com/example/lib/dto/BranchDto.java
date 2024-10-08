package com.example.lib.dto;

import com.example.lib.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BranchDto {
   @NotBlank(message = "branchName is required")
    private String branchName;
    @NotBlank(message = "branchCode is required")
    private String branchCode;
    @NotBlank(message = "address is required")
    private String address;
}
