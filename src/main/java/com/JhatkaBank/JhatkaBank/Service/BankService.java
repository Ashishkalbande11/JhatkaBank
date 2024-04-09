package com.JhatkaBank.JhatkaBank.Service;

import com.JhatkaBank.JhatkaBank.BankDTO.AccountDTO;
import com.JhatkaBank.JhatkaBank.Model.BankAccount;
import com.JhatkaBank.JhatkaBank.Service.Implementations.AccountService;

import java.util.List;

public interface BankService {
    AccountDTO createAccount (AccountDTO accountDTO);
    AccountDTO getAccByAccNo(Long accNo);
    AccountDTO depositAmount(Long accNo, double amount);
    AccountDTO withdrawAmount(Long accNo, double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(Long accNo);
}
