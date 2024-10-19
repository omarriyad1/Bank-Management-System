package com.example.lib.controller;

import com.example.lib.dto.AccountDto;
import com.example.lib.model.Account;
import com.example.lib.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class accountController {
    /*
    PostMapping("/accounts"): Endpoint to create a new account.*/
    @Autowired
    accountService service;
    @PostMapping("/createAccount")
    @ResponseBody
    public ResponseEntity<String> createAccount(@RequestBody AccountDto account) {
        Account acc=service.createAccount(account);
        if(acc==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not found");
        }
        return ResponseEntity.ok(acc.toString());
    }
    @GetMapping("/getAcountDetails")
    @ResponseBody
    public Account getAccountDetails(@RequestBody Long accountId) {
        return service.getAccountDetails(accountId);
    }
    @PostMapping("/updateBalance")
    @ResponseBody
    public Account updateBalance(@RequestBody  Long accountId, @RequestBody double balance) {
           return service.updateAccountBalance(accountId,balance);
    }
    @PostMapping("/transfer")
    @ResponseBody
    public ResponseEntity<String> transferr(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam Double amount) {
        if( service.transfer(fromAccountId, toAccountId, amount))
        {

            return ResponseEntity.ok("Successful transfer");
        }
        return ResponseEntity.status(400).body("Transfer failed");
    }



}
