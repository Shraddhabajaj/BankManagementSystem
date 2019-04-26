package com.ewallet.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewallet.app.entities.CreateAccount;
import com.ewallet.app.entities.Transaction;
import com.ewallet.app.exception.ResourceNotFoundException;
import com.ewallet.app.repository.CreateAccountRepo;
import com.ewallet.app.repository.TransactionRepository;

@Service
public class TransactionImpl implements TransactionInt {

	@Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CreateAccountRepo accountRepository;
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	getAllTransactions()
	 - Input Parameters		:	
	 - Return Type			:	List<Transaction>
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to display all transactions
	 ********************************************************************************************************/     
	public List<Transaction> getAllTransactions() {
		List<Transaction> result = new ArrayList<>();
		transactionRepository.findAll().forEach(e -> result.add(e));
		return result;
	}
	
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	insertTransaction()
	 - Input Parameters		:	Long fromAccNo,Transaction transaction
	 - Return Type			:	Transaction
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to insert transactions in deposit or withdraw
	 ********************************************************************************************************/  
	public Transaction insertTransaction(Long fromAccNo,Transaction transaction)

	{
		System.out.println("Transaction Service Called...");
		return accountRepository.findById(fromAccNo).map(account -> {
			System.out.println(account.getfName());
			transaction.setToaccount(account);
			System.out.println(account.getfName());
			String tType=transaction.getType();
			if(tType.equals("Deposit")||tType.equals("deposit"))
				account.setBalance(account.getBalance()+transaction.getAmount());
			else if(tType.equals("Withdraw")||tType.equals("withdraw"))
					account.setBalance(account.getBalance()-transaction.getAmount());
			accountRepository.save(account);
			System.out.println("Account Balance Updated");
            transaction.setFromaccount(account);
            System.out.println("Transaction started");
            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new ResourceNotFoundException("Account " + fromAccNo + " not found"));
	}
	
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	fundTransferTransaction()
	 - Input Parameters		:	Long fromAccNo,Long toAccNo,Transaction transaction
	 - Return Type			:	Transaction
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to insert transactions in fund transfer
	 ********************************************************************************************************/  
	@Override
	public Transaction fundTransferTransaction(Long fromAccNo, Long toAccNo, Transaction transaction) {
		System.out.println("Fund Transfer Transaction Service Called...");
		CreateAccount fAccount=accountRepository.findById(fromAccNo).get();
		CreateAccount tAccount=accountRepository.findById(toAccNo).get();
		
		if(fAccount!=null && tAccount!=null)
		{
			transaction.setFromaccount(fAccount);
			transaction.setToaccount(tAccount);
			
			fAccount.setBalance(fAccount.getBalance()-transaction.getAmount());
			accountRepository.save(fAccount);
			tAccount.setBalance(tAccount.getBalance()-transaction.getAmount());
			accountRepository.save(tAccount);
		}
		return transactionRepository.save(transaction);
	}

}
