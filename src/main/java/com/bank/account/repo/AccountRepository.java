package com.bank.account.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.account.Details.AccountDetails;

@Repository
public interface AccountRepository
 extends CrudRepository<AccountDetails, Long> {
}

