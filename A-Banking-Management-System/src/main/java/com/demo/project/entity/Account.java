package com.demo.project.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="accounts")
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="acoount_holder_name")
	private String AccountHolderName;
	
	private double balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return AccountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	 public Account() {
	    }
	public Account(int id, String accountHolderName, double balance) {
		super();
		this.id = id;
		AccountHolderName = accountHolderName;
		this.balance = balance;
	}

}
