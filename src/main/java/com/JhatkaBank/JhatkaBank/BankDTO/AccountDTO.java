package com.JhatkaBank.JhatkaBank.BankDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long accNo;
    private  String accHolderName;
    private  double amount;
}
