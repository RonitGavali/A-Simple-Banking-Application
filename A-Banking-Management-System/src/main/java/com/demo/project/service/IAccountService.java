package com.demo.project.service;


import java.util.List;

import com.demo.project.model.AccountDto;

public interface IAccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(int id);
	
	AccountDto deposit(int id,double amount);
	
	AccountDto withdraw(int id,double amount);
	
	List<AccountDto>getAllAccounts();
	
	void delete(int id);

}
