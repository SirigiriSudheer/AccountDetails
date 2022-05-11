package com.bank.account.Details;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AccountWithdrawlDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accountNumber;
    private Date timeStamp;
    private String type;
    private double balance;
}
