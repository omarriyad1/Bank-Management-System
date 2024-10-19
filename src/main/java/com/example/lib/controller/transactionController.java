package com.example.lib.controller;

import com.example.lib.dto.TransactionDto;
import com.example.lib.model.Transaction;
import com.example.lib.service.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api3")
public class transactionController {
    @Autowired
    private transactionService service;
    @PostMapping("/makeTransaction")
    @ResponseBody
    public Transaction transaction(@RequestBody TransactionDto transaction) {
        return service.createTransaction(transaction);
    }

//    @GetMapping("/getMyTransactions")
//    @ResponseBody
//    public List<Transaction> getMyTransactions(@RequestBody Long transactionId) {
//        return service.getTransactionByAccountId(transactionId);
//    }

}
