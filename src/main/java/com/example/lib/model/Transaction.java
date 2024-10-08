package com.example.lib.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TransactionId;
    private transactionType type;
    private double amount;
    private Timestamp timestamp;



}
enum transactionType {
    DEPOSIT,
    WITHDRAWAL,
    TRANSFER;
}