package com.example.lib.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Account {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
     private double balance;
     private String accountType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sourceAccount")
    @JsonBackReference
    private Set<Account> sourceAccounts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetAccount")
    @JsonBackReference
    private Set<Account> targetAccounts;
}
