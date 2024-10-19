package com.example.lib.repository;

import com.example.lib.model.Account;
import com.example.lib.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
   // List<Transaction> getTransactionsByAccount(Account referenceById);
    Account getAccountByAccountId(Long accountId);
    List<Transaction> getTransactionsByAccountId(Long accountId);

//    List<Transaction> getTransactionsByAccount(Account account);

//    Account getAccountsByAccountId(@NotNull Long sourceUserId);
}
