package com.JhatkaBank.JhatkaBank.Controller;

import ch.qos.logback.core.read.ListAppender;
import com.JhatkaBank.JhatkaBank.BankDTO.AccountDTO;
import com.JhatkaBank.JhatkaBank.Service.Implementations.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jhatkabank/accounts")
public class BankController {
    @Autowired
    AccountService accountService;

    @PostMapping("/openaccount")
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{accNo}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long accNo){
        AccountDTO accountDTO = accountService.getAccByAccNo(accNo);
        return ResponseEntity.ok(accountDTO);
    }
    @PutMapping("/{accNo}/deposit")
    public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long accNo, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.depositAmount(accNo, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/{accNo}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long accNo, @RequestBody Map<String , Double> request){
        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdrawAmount(accNo, amount);
        return ResponseEntity.ok(accountDTO);
    }
    @GetMapping("/allaccounts")
    public ResponseEntity<List<AccountDTO>> gellAllAccount(){
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{accNo}/delete")
    public ResponseEntity<String> deleteAccount(Long accNo){
        accountService.deleteAccount(accNo);
        return ResponseEntity.ok("Account deleted successfully!");
    }
}
