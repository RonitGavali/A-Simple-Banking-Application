package com.demo.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.model.AccountDto;
import com.demo.project.service.IAccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		
		
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto>getAccountById(@PathVariable int id){
		
	AccountDto accountDto=	accountService.getAccountById(id);
	
	return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto>deposit(@PathVariable int id,@RequestBody Map<String,Double> request){
		
	AccountDto accountDto=	accountService.deposit(id, request.get("amount"));
	
	
	return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto>withdraw(@PathVariable int id,@RequestBody Map<String,Double> request){
		AccountDto accountDto=accountService.withdraw(id,request.get("amount"));
		
		return ResponseEntity.ok(accountDto);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AccountDto>>getAllAccounts(){
		
	List<AccountDto> accountDto	=accountService.getAllAccounts();
	
	return ResponseEntity.ok(accountDto);
	
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>delete(@PathVariable int id){
		
		accountService.delete(id);
		
		return ResponseEntity.ok("The Account deleted successfully");
	}

}
