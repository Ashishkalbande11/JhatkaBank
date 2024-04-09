package com.JhatkaBank.JhatkaBank.BankMapper;

import com.JhatkaBank.JhatkaBank.BankDTO.AccountDTO;
import com.JhatkaBank.JhatkaBank.Model.BankAccount;

public class AccountMapper {
    public static BankAccount mapToAccount(AccountDTO accountDTO){
        BankAccount bankAccount = new BankAccount(
                accountDTO.getAccNo(),
                accountDTO.getAccHolderName(),
                accountDTO.getAmount()
        );
        return bankAccount;
    }
    public static AccountDTO mapToAccountDTO(BankAccount bankAccount){
        AccountDTO accountDTO = new AccountDTO(
                bankAccount.getAccNo(),
                bankAccount.getAccHolderName(),
                bankAccount.getAmount()
        );
        return accountDTO;
    }
}
