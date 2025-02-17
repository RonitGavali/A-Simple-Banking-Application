package com.demo.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.project.entity.Account;
import com.demo.project.mapper.AccountMapper;
import com.demo.project.model.AccountDto;
import com.demo.project.repository.AccountRepository;


@Service
public class AccountServiceImpl implements IAccountService{
	
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account= AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(int id) {
	Account account=	accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account Does not exists")));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(int id, double amount) {
		Account account= 	accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account Does not exists")));
		
		double totalBalance =account.getBalance()+ amount;
		
		account.setBalance(totalBalance);
	   Account savedAccount= accountRepository.save(account);
		return  AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(int id, double amount) {
		Account account= 	accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account Does not exists")));
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Amoubt in  account ");
			
		}
		double totalBalance=account.getBalance()-amount;
		account.setBalance(totalBalance);
		  Account savedAccount= accountRepository.save(account);
		
		
		  return  AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return  accountRepository.findAll().stream().map((account)-> AccountMapper.mapToAccountDto(account)).
		collect(Collectors.toList());
		
		
		
	}

	@Override
	public void delete(int id) {
		
		Account account=	accountRepository.findById(id).orElseThrow((()-> new RuntimeException("Account Does not exists")));
		accountRepository.delete(account);
		
		
	}

}
