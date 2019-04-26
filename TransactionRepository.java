package com.ewallet.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewallet.app.entities.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction , Long>{
	//List<Transaction> findTransactions(Long fromaccNo);
	

}
