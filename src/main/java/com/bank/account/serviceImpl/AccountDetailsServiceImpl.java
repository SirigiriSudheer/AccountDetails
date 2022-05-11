package com.bank.account.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bank.account.Details.AccountDepositDetails;
import com.bank.account.Details.AccountDetails;
import com.bank.account.Details.AccountWithdrawlDetails;
import com.bank.account.repo.AccountRepository;
import com.bank.account.repo.TransDeposit;
import com.bank.account.repo.TransRepo;
import com.bank.account.service.AccountDetailsService;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransRepo transRepository;
	
	@Autowired
	TransDeposit transDeposit;
	
	@Autowired
    private JdbcTemplate template;
	
	@Override
	public AccountDetails saveAccountDetails(AccountDetails accountDetails) {
		return accountRepository.save(accountDetails);
	}


	@Override
	public Double getBalanceByAccountNumber(String accountNumber) {
		String sql = "SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NUMBER=?";

		Double balance = template.queryForObject(sql, new Object[]{accountNumber}, Double.class);

        return balance;
	}
	
	@Override
	public List<AccountDepositDetails> getDepositTransaction(String accountNumber) {
		String sql = "SELECT * FROM ACCOUNT_DEPOSIT_DETAILS WHERE ACCOUNT_NUMBER=? AND TIMESTAMP >= CURRENT_TIMESTAMP - 7";

		List<AccountDepositDetails> details =  template.queryForList(sql, new Object[]{accountNumber}, AccountDepositDetails.class);

        return details;
	}
	
	@Override
	public List<AccountWithdrawlDetails> getWithdrawlTransaction(String accountNumber) {
		String sql = "SELECT * FROM ACCOUNT_WITHDRAWL_DETAILS WHERE ACCOUNT_NUMBER=? AND TIMESTAMP >= CURRENT_TIMESTAMP - 7";

		List<AccountWithdrawlDetails> details =  template.queryForList(sql, new Object[]{accountNumber}, AccountWithdrawlDetails.class);

        return details;
	}


	@Override
	public AccountDepositDetails saveAccountDepositDetails(AccountDepositDetails accountDepositDetails) {
		
		return transDeposit.save(accountDepositDetails);
	}


	@Override
	public AccountWithdrawlDetails saveAccountWithdrawlDetails(AccountWithdrawlDetails accountWithdrawlDetails) {
		
		return transRepository.save(accountWithdrawlDetails);
	}

}
