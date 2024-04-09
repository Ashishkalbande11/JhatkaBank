package com.JhatkaBank.JhatkaBank.Repository;

import com.JhatkaBank.JhatkaBank.Model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankAccount,Long> {
}
