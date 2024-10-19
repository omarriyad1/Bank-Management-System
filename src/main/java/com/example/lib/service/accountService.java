package com.example.lib.service;

import com.example.lib.dto.AccountDto;
import com.example.lib.dto.BranchDto;
import com.example.lib.dto.TransactionDto;
import com.example.lib.model.Account;
import com.example.lib.model.Branch;
import com.example.lib.model.Transaction;
import com.example.lib.model.User;
import com.example.lib.repository.AccountRepo;
import com.example.lib.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class accountService {
    @Autowired
    AccountRepo accountRepository;
    @Autowired
    transactionService transactionservice;
    TransactionDto transactionDto;
    @Autowired
    UserRepo userRepository1;
    public Account createAccount(AccountDto accountdto) {
        Account account = new Account();
        account.setAccountType(accountdto.getAccountType());
        account.setBalance(accountdto.getBalance());

        User usera = userRepository1.findById(accountdto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
//        if(userRepository.findById(accountdto.getUserId()) != null) {
//            User u=userRepository.findById(accountdto.getUserId()).get();
            account.setUser(usera);
            return accountRepository.save(account);
//        }
//        else {
//            return null;
//        }


        //account.setUser();
        //accountdto.getUserId());

    }
    public Account getAccountDetails(Long accountId) {
        return accountRepository.getReferenceById(accountId);
    }
    public Account updateAccountBalance(Long accountId, double balance) {
        accountRepository.getReferenceById(accountId).setBalance(balance);
        return accountRepository.save(accountRepository.getReferenceById(accountId));
    }
    public boolean transfer(Long fromId, Long toId, double amount) {
        Account fromAccount = accountRepository.getReferenceById(fromId);
        Account toAccount = accountRepository.getReferenceById(toId);
        double k= fromAccount.getBalance();
        double m=k;
        if(k<amount)
        {
            return false;
        }
        else {
        k-=amount;
        fromAccount.setBalance(k);
        double l =toAccount.getBalance();
        l+=amount;
        toAccount.setBalance(l);
        if(m != k && amount!=0)
        {
//            TransactionDto transactionDto1 = new TransactionDto();
//            TransactionDto transactionDto2;
//            transactionDto1.setAmount(amount);
//            transactionDto1.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//            transactionDto1.setSource_userId(fromId);
//            transactionDto1.setTarget_userId(toId);
//            Transaction transaction10 = new Transaction();
//            Transaction transaction20 = new Transaction();
//            transaction10.setAmount(amount);
//            transaction20.setAmount(amount);
//
//
//            transactionDto.setSource_userId(fromId);
//            transactionDto.setTarget_userId(toId);
//            transactionDto.setAmount(amount);
//            transactionDto.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//            Transaction transaction = transactionservice.createTransaction(transactionDto);
//            TransactionDto
//


                    //------------------
            TransactionDto t10 = new TransactionDto();
            TransactionDto t20 = new TransactionDto();
            t10.setAmount(amount);
            t10.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            t10.setAccount_Id(fromId);
            t10.setType("Transfer");
            t20.setAmount(amount);
            t20.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            t20.setAccount_Id(fromId);
            t20.setType("Transfer");
            Transaction transaction1 = transactionservice.createTransaction(t10);
            Transaction transaction2 = transactionservice.createTransaction(t20);

            return true;
        }
        else {
            return false;
        }}
    }
    public List<Transaction> getMyTransactions(Long userId) {
        return accountRepository.getTransactionsByAccountId(userId);
    }

}
