package com.JhatkaBank.JhatkaBank.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accNo;
    @Column(name = "acc_holder_name", nullable = false)
    private String accHolderName;
    @Column(name = "acc_balance",nullable = false)
    private  double amount;
}
