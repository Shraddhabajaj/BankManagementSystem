package com.ewallet.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ewallet.app.entities.*;
@Service("transactionService")
public interface TransactionInt {

	public List<Transaction> getAllTransactions();
	public Transaction insertTransaction(Long fromAccNo,Transaction transaction);
	public Transaction fundTransferTransaction(Long fromAccNo,Long toAccNo,Transaction transaction);
	//public List<Transaction> getAllTransactionsByAccountNo(Long accountNo);
}
