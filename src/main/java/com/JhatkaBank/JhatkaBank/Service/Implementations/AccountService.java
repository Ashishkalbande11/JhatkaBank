package com.JhatkaBank.JhatkaBank.Service.Implementations;

import com.JhatkaBank.JhatkaBank.BankDTO.AccountDTO;
import com.JhatkaBank.JhatkaBank.BankMapper.AccountMapper;
import com.JhatkaBank.JhatkaBank.Model.BankAccount;
import com.JhatkaBank.JhatkaBank.Repository.BankRepository;
import com.JhatkaBank.JhatkaBank.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements BankService {
    @Autowired
    BankRepository bankRepository;
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        BankAccount bankAccount = AccountMapper.mapToAccount(accountDTO);
        BankAccount saveBankAccount = bankRepository.save(bankAccount);
        return AccountMapper.mapToAccountDTO(saveBankAccount);
    }

    @Override
    public AccountDTO getAccByAccNo(Long accNo) {
       BankAccount bankAccount = bankRepository
                .findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDTO(bankAccount);
    }

    @Override
    public AccountDTO depositAmount(Long accNo, double amount) {
        BankAccount bankAccount = bankRepository
                .findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        double totalamount = bankAccount.getAmount() + amount;
        bankAccount.setAmount(totalamount);
        BankAccount saveAccount = bankRepository.save(bankAccount);
        return AccountMapper.mapToAccountDTO(saveAccount);
    }

    @Override
    public AccountDTO withdrawAmount(Long accNo, double amount) {
        BankAccount bankAccount = bankRepository
                .findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        if(bankAccount.getAmount() < amount){
            throw new RuntimeException("Insufficient Balance !!");
        }
        double totalAmount = bankAccount.getAmount() - amount;
        bankAccount.setAmount(totalAmount);
        BankAccount saveAccount = bankRepository.save(bankAccount);

        return AccountMapper.mapToAccountDTO(saveAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<BankAccount> bankAccounts = bankRepository.findAll();
        return bankAccounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long accNo) {
        BankAccount bankAccount = bankRepository
                .findById(accNo)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        bankRepository.deleteById(accNo);
    }
}
