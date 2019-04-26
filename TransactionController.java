package com.ewallet.app.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ewallet.app.entities.*;
import com.ewallet.app.service.*;


@Controller
@RequestMapping("/transactions")
public class TransactionController {

	
	@Autowired
    private CreateAccountInt accountService;
	
	@Autowired
	private TransactionInt transactionService;
	
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	getTransactionByAccountNo()
	 - Input Parameters		:	@Valid @ModelAttribute("account")CreateAccount account
	 - Return Type			:	ModelAndView
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to display all transactions
	 ********************************************************************************************************/	
    @GetMapping("/")
    public ModelAndView getTransactionByAccountNo(@Valid @ModelAttribute("account")CreateAccount account)
    {
    	ModelAndView mv=new ModelAndView("printtransaction");
    	List<Transaction> tList=transactionService.getAllTransactions();
    	mv.addObject("tList",tList);
    	return mv;
    }
    
    @GetMapping("/printtransaction")
   	public String printTransaction()
   	{
   		return "printtransaction";
   	}
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	withdraw() and withrawAmount()
	 - Input Parameters		:	@RequestParam Long fromAccNo, @RequestParam String type, 
	 							@RequestParam Double amount
	 - Return Type			:	ModelAndView
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to withdraw money
	 ********************************************************************************************************/    
    @GetMapping("/withdraw")
	public String  withdraw()
	{
		
		return "withdrawMoney";
	}
    
    @PostMapping("/withdraw")
    public ModelAndView withdrawAmount(@RequestParam Long fromAccNo, @RequestParam String type, @RequestParam Double amount)

	{
		System.out.println("Account No : "+fromAccNo);
		Transaction transaction=new Transaction();
		transaction.setAmount(amount);
		transaction.setType(type);
		System.out.println("Calling ");
		ModelAndView mv=new ModelAndView("showTransaction");
		Transaction t=transactionService.insertTransaction(fromAccNo,transaction);
	    mv.addObject("transaction", t);
		return mv;
	}
   
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	fundsTransfer()
	 - Input Parameters		:	@RequestParam Long fromAccNo,@RequestParam Long toAccNo,
	  							@RequestParam String type, @RequestParam Double amount
	 - Return Type			:	ModelAndView
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to transfer fund
	 ********************************************************************************************************/
    @GetMapping("/fundsTransfer")
	public String fundsTransfer()

	{
		return "fundsTransfer";
	}
	
	@PostMapping("/fundsTransfer")
	public ModelAndView fundsTransfer(@RequestParam Long fromAccNo, @RequestParam Long toAccNo, @RequestParam String type,@RequestParam Double amount)
	{
		System.out.println("From Account No : "+fromAccNo);
		System.out.println("To Account No : "+fromAccNo);
		Transaction transaction=new Transaction();
		transaction.setAmount(amount);
		transaction.setType(type);
		ModelAndView mv=new ModelAndView("showTransaction");
		Transaction t=transactionService.fundTransferTransaction(fromAccNo,toAccNo,transaction);
	    mv.addObject("transaction", t);
		return mv;
	}
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	depositAmount()
	 - Input Parameters		:	@RequestParam Long fromAccNo, @RequestParam String type, 
	 							@RequestParam Double amount
	 - Return Type			:	ModelAndView
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to deposit money
	 ********************************************************************************************************/ 
	@GetMapping("/deposit")
	public String depositAmount()
	{
		return "deposit";
	}
	
	@PostMapping("/deposit")
	public ModelAndView depositAmount(@RequestParam Long fromAccNo, @RequestParam String type, @RequestParam Double amount)
	{
		System.out.println("Account No : "+fromAccNo);
		Transaction transaction=new Transaction();
		transaction.setAmount(amount);
		transaction.setType(type);
		ModelAndView mv=new ModelAndView("showTransaction");
		Transaction t=transactionService.insertTransaction(fromAccNo,transaction);
	    mv.addObject("transaction", t);
		return mv;
	}	

}
