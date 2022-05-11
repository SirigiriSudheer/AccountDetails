package com.bank.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.Details.AccountDepositDetails;
import com.bank.account.Details.AccountDetails;
import com.bank.account.Details.AccountWithdrawlDetails;
import com.bank.account.service.AccountDetailsService;

@RestController
public class AccountDetailsController {
	@Autowired
	private AccountDetailsService accountDetailsService;

	@PostMapping("/balance")
	public AccountDetails saveAccountDetails(@RequestBody AccountDetails accountDetails) {
		return accountDetailsService.saveAccountDetails(accountDetails);
	}

	@PostMapping("/deposit")
	public AccountDepositDetails saveDeposit(@RequestBody AccountDepositDetails accountDepositDetails) {
		return accountDetailsService.saveAccountDepositDetails(accountDepositDetails);
	}

	@PostMapping("/withdrawl")
	public AccountWithdrawlDetails saveWithdrawl(@RequestBody AccountWithdrawlDetails accountWithdrawlDetails) {
		return accountDetailsService.saveAccountWithdrawlDetails(accountWithdrawlDetails);
	}

	@RequestMapping("/balance/{accountNumber}")
	public Double findBalance(@PathVariable String accountNumber) {

		return accountDetailsService.getBalanceByAccountNumber(accountNumber);
	}
	
	@RequestMapping("/withdrawl/{accountNumber}")
	public List<AccountWithdrawlDetails> findWithdrawlTrans(@PathVariable String accountNumber) {

		return accountDetailsService.getWithdrawlTransaction(accountNumber);
	}
	
	@RequestMapping("/deposit/{accountNumber}")
	public List<AccountDepositDetails> findCity(@PathVariable String accountNumber) {

		return accountDetailsService.getDepositTransaction(accountNumber);
	}

}
