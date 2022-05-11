package com.bank.account.service;

import java.util.List;

import com.bank.account.Details.AccountDepositDetails;
import com.bank.account.Details.AccountDetails;
import com.bank.account.Details.AccountWithdrawlDetails;

public interface AccountDetailsService {
	public AccountDetails saveAccountDetails(AccountDetails accountDetails);
	public Double getBalanceByAccountNumber(String accountNumber);
	public AccountDepositDetails saveAccountDepositDetails(AccountDepositDetails accountDepositDetails);
	public AccountWithdrawlDetails saveAccountWithdrawlDetails(AccountWithdrawlDetails accountWithdrawlDetails);
	public List<AccountDepositDetails> getDepositTransaction(String accountNumber);
	public List<AccountWithdrawlDetails> getWithdrawlTransaction(String accountNumber);
}
