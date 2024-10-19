package com.example.lib.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    private String transactionType;
    private double amount;
    @CreationTimestamp
    private LocalDateTime timestamp;


    //source acc
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;
//    //target acc
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @JoinColumn(name = "target_account_id")
//    private Account targetAccount;



}
//enum transactionType {
//    DEPOSIT,
//    WITHDRAWAL,
//    TRANSFER;
//}