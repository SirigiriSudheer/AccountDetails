package com.bank.account.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.account.Details.AccountDepositDetails;

@Repository
public interface TransDeposit
 extends CrudRepository<AccountDepositDetails, Long> {
}