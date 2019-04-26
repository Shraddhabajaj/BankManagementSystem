package com.ewallet.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewallet.app.repository.CreateAccountRepo;
import com.ewallet.app.entities.CreateAccount;
@Service
public class CreateAccountImpl implements CreateAccountInt {

	@Autowired
	private CreateAccountRepo car;
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	getAllAccountDetails()
	 - Input Parameters		:	
	 - Return Type			:	List<CreateAccount>
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to display all account details
	 ********************************************************************************************************/ 
	@Override
	public List<CreateAccount> getAllAccountDetails() {
		List<CreateAccount> result = new ArrayList<>();
		//List<CreateAccount> cal = car.findAccountId();
		car.findAll().forEach(e -> result.add(e));
		return result;
	}
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	save()
	 - Input Parameters		:	CreateAccount account
	 - Return Type			:	void
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to save account details
	 ********************************************************************************************************/ 
	  @Override public void save(CreateAccount account) { car.save(account);
	 
	  }
		//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	showBalanceDetails()
		 - Input Parameters		:	Long accNo
		 - Return Type			:	CreateAccount
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to show balance by account number
		 ********************************************************************************************************/ 
	@Override
	public CreateAccount showBalanceDetails(Long accNo) {
		
		CreateAccount ca= car.findById(accNo).get();
		System.out.println("Got Id");
		return ca;
	}
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	delete()
	 - Input Parameters		:	CreateAccount account
	 - Return Type			:	void
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to delete an account
	 ********************************************************************************************************/	  
	 @Override 
	 public void delete(CreateAccount account) { car.delete(account); }
		//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	findById()
		 - Input Parameters		:	Long accNo
		 - Return Type			:	CreateAccount
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to find an account by account number
		 ********************************************************************************************************/		  
	  @Override 
	  public CreateAccount findById(Long accNo) {
	  
	  CreateAccount account=car.findById(accNo).get(); 
	  return account;
	  
	  }
	 

}
