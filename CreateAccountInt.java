package com.ewallet.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ewallet.app.entities.CreateAccount;
@Service("cai")
public interface CreateAccountInt {
	public List<CreateAccount> getAllAccountDetails();
	/*
	 * public void createAccountDetails(Long accNo, String fName, String lName,
	 * double mobile, String email, String pasword,double balance);*/ 
	public void save( CreateAccount account);
	  
	  public void delete(CreateAccount account); 
	  public CreateAccount findById(Long accNo);
	 
	public CreateAccount showBalanceDetails(Long accNo);
}
