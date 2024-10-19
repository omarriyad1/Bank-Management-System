package com.example.lib.service;

import com.example.lib.dto.TransactionDto;
import com.example.lib.model.Account;
import com.example.lib.model.Transaction;
import com.example.lib.repository.AccountRepo;
import com.example.lib.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class transactionService {
    /*- `
-
- `@GetMapping("/transactions/date-range")`: Endpoint to get transactions within a specific date range.*/
    @Autowired
   private TransactionRepo transactionRepo;
    @Autowired
    private AccountRepo accountRepo;
    private accountService accountService;
    public Transaction createTransaction(TransactionDto transactiondto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactiondto.getAmount());
        transaction.setTransactionType(transactiondto.getType());
        transaction.setTimestamp(LocalDateTime.now());
        String ll= transactiondto.getType();
        ll.toLowerCase();
        if(ll.equals("deposit"))
        {
            transaction.setTransactionType(ll);
            transaction.setAmount(transactiondto.getAmount());
            transaction.setAccount(accountRepo.getAccountByAccountId(transactiondto.getAccount_Id()));
            //Account omar = accountRepo.getReferenceById(transactiondto.getAccount_Id());
            Account h = accountRepo.getReferenceById(transactiondto.getAccount_Id());
            h.setBalance(h.getBalance()+transactiondto.getAmount());

        }
        else if(ll.equals("withdraw"))
        {
            transaction.setTransactionType(ll);
            transaction.setAmount(transactiondto.getAmount());
            transaction.setAccount(accountRepo.getAccountByAccountId(transactiondto.getAccount_Id()));
            Account h = accountRepo.getAccountByAccountId(transactiondto.getAccount_Id());
            h.setBalance(h.getBalance()-transactiondto.getAmount());

        }
        //DEPOSIT, WITHDRAWAL

        //transaction.setAccount(accountRepo.getReferenceById(transactiondto.getUser_Id()));
        return transactionRepo.save(transaction);
    }
    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }
public List<Transaction> getTransactionByAccountId(Long accountId) {
       if( accountService.getMyTransactions(accountId) !=null)
       {
           return accountService.getMyTransactions(accountId);
       }
       else
       {
           return null;
       }

}
//public List<Transaction> getTransactionByDate(String timestamp1) {
//   // SimpleDateFormat dateFormat = new SimpleDateFormat(timestamp1);
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Adjust pattern as needed
//    List<Transaction> transactions = new ArrayList<>();
//    try {
//        // Parse the input string to a java.util.Date object
//        java.util.Date parsedDate = dateFormat.parse(timestamp1);
//
//        // Convert java.util.Date to java.sql.Timestamp
//        Timestamp timestamp = new Timestamp(parsedDate.getTime());
//    }catch (ParseException e) {
//        e.printStackTrace();
//    }
//    return transactions;
//}

}

