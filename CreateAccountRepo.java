package com.ewallet.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewallet.app.entities.CreateAccount;
@Repository
public interface CreateAccountRepo extends JpaRepository<CreateAccount, Long> {

	//List<CreateAccount> findAccounts(Long accNo);
}


