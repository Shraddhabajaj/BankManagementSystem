package com.ewallet.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ewallet.app.entities.*;
import com.ewallet.app.service.CreateAccountInt;

@Controller
@RequestMapping("/ewallet")
public class AccountsController {
	@Autowired
	private CreateAccountInt cai;

	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	findAll()
	 - Input Parameters		:	
	 - Return Type			:	ModelAndView
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to retrieve all the account details
	 ********************************************************************************************************/
	
	@GetMapping("/")
	public ModelAndView findAll() {
		List<CreateAccount> accountList = cai.getAllAccountDetails();
		ModelAndView modelAndView = new ModelAndView("listaccountdetails");
		modelAndView.addObject("ACCOUNTLIST", accountList);
		return modelAndView;
	}
	//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	createAccount()
		 - Input Parameters		:	
		 - Return Type			:	ModelAndView
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to create a new account
		 ********************************************************************************************************/
	@GetMapping("/add")
	public ModelAndView createAccount()
	{
		CreateAccount account=new CreateAccount();
		System.out.println("Creating Account...");
		ModelAndView modelAndView = new ModelAndView("createacount");
		modelAndView.addObject("account",account);
		return modelAndView;
	}
	//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	requestLogin()
		 - Input Parameters		:	@RequestParam Long user,@RequestParam String password
		 - Return Type			:	ModelAndView
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to check for user's credentials for login
		 ********************************************************************************************************/

	@PostMapping("/checkuser")
	public ModelAndView requestLogin(@RequestParam Long user, @RequestParam String password) {
		Long temp=user;
		ModelAndView modelAndView = null;
		List<CreateAccount> accountList = cai.getAllAccountDetails();
		if ((user==104) && (password.equals("admin"))) {
			modelAndView = new ModelAndView("adminhome");
		} else {
			for(CreateAccount acc : accountList ) {
				if((temp==acc.getAccNo()) && (password.equals(acc.getPassword()))) {
					modelAndView = new ModelAndView("home");
					modelAndView.addObject("CURRUSER",acc);
				}
			}
			
		}
		return modelAndView;
	}
	//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	save()
		 - Input Parameters		:	@RequestParam String fName, @RequestParam String lName, @RequestParam Long phone,
									@RequestParam String email, @RequestParam String password, 
									@RequestParam String cPassword, @RequestParam double balance
		 - Return Type			:	ModelAndView
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to get all the input from new account and save it in accounts table
		 ********************************************************************************************************/
	
	@PostMapping("/save")
	public ModelAndView save(@RequestParam String fName, @RequestParam String lName, @RequestParam Long phone,
			@RequestParam String email, @RequestParam String password, @RequestParam String cPassword, @RequestParam double balance) {
		CreateAccount account=new CreateAccount();
		//account.setAccNo(accNo);
		account.setfName(fName);
		account.setlName(lName);
		account.setPhone(phone);
		account.setEmail(email);
		account.setPassword(password);
		account.setcPassword(cPassword);
		account.setBalance(balance);
		System.out.println("saving data");
		
		cai.save(account);
		List<CreateAccount> accountsList = cai.getAllAccountDetails();
		ModelAndView modelAndView = new ModelAndView("listaccountdetails");
		modelAndView.addObject("ACCOUNTLIST", accountsList);
		return modelAndView;
	}
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
			 - Function Name		:	show()
			 - Input Parameters		:	@RequestParam Long accNo
			 - Return Type			:	ModelAndView
			 - Author				:	Shraddha Bajaj
			 - Creation Date		:	12/04/2019
			 - Description			:   function is used to show balance
		********************************************************************************************************/
	
	@GetMapping("/show")
	public String showMethod() {
		return "show";
	}
	
	@PostMapping("/show")
	public ModelAndView show(@RequestParam Long accNo)
	{
		ModelAndView modelAndView = new ModelAndView("showbalance");
		CreateAccount account = cai.showBalanceDetails(accNo);
		modelAndView.addObject("ACCOUNT", account);
		return modelAndView;
	}
	//------------------------ PayGate Application--------------------------
	/*******************************************************************************************************
	 - Function Name		:	updateMethod() and modify()
	 - Input Parameters		:	@RequestParam Long accNo
	 - Return Type			:	ModelAndView
	 - Author				:	Shraddha Bajaj
	 - Creation Date		:	12/04/2019
	 - Description			:   function is used to get the account number  for updation
	 ********************************************************************************************************/	
	  @GetMapping("/modify") public String updateMethod() { return "modify"; }
	  
	  
	  @PostMapping("/modify") public ModelAndView modify(@RequestParam Long accNo)
	  { System.out.println("In update"); 
	  CreateAccount account =cai.findById(accNo); 
	  System.out.println("going to update"); 
	  ModelAndView modelAndView = new ModelAndView("updateaccount");
	  modelAndView.addObject("ACCOUNT", account); return modelAndView; }
		//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	updateDetailsMethod() and update()
		 - Input Parameters		:	@RequestParam Long accNo
		 - Return Type			:	ModelAndView
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to update account details
		 ********************************************************************************************************/
	  @GetMapping("/updateaccount") public String updateDetailsMethod() { return
	  "updateaccount"; }
	  
	  @PostMapping("/updateaccount") public ModelAndView update(@RequestParam Long
	  accNo,@RequestParam String fName, @RequestParam String lName, @RequestParam
	  Long phone,
	  
	  @RequestParam String email, @RequestParam String password, @RequestParam
	  String cPassword) { CreateAccount account = new CreateAccount();
	  account.setAccNo(accNo); System.out.println("Got the Id");
	  account.setfName(fName); account.setlName(lName); account.setPhone(phone);
	  account.setEmail(email); account.setPassword(password);
	  account.setcPassword(cPassword); System.out.println("updating data");
	  cai.save(account); List<CreateAccount> accountList =
	  cai.getAllAccountDetails(); ModelAndView modelAndView = new
	  ModelAndView("listaccountdetails"); modelAndView.addObject("ACCOUNTLIST",
	  accountList); return modelAndView; }
	 
		//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	deleteMethod() and delete()
		 - Input Parameters		:	@RequestParam Long accNo
		 - Return Type			:	ModelAndView
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to delete an account and display the updated list of accounts
		 ********************************************************************************************************/	  
	@GetMapping("/delete")
	public String deleteMethod() {
		return "delete";
	}
	
	  @PostMapping("/delete") 
	  public ModelAndView delete(@RequestParam Long accNo) {
	  CreateAccount account = cai.findById(accNo); 
	  cai.delete(account);
	  List<CreateAccount> accountsList = cai.getAllAccountDetails(); 
	  ModelAndView modelAndView = new ModelAndView("listaccountdetails");
	  modelAndView.addObject("ACCOUNTLIST", accountsList); 
	  return modelAndView; }
		//------------------------ PayGate Application--------------------------
		/*******************************************************************************************************
		 - Function Name		:	retrieveMethod() and retrieve()
		 - Input Parameters		:	@RequestParam Long accNo
		 - Return Type			:	ModelAndView
		 - Author				:	Shraddha Bajaj
		 - Creation Date		:	12/04/2019
		 - Description			:   function is used to retrieve an account by Account Number
		 ********************************************************************************************************/	  
	  @GetMapping("/retrieve")
		public String retrieveMethod() {
			return "retrieve";
		}
	  
	  @PostMapping("/retrieve") 
	  public ModelAndView retrieve(@RequestParam Long accNo) 
	  { CreateAccount account = cai.findById(accNo); 
	  ModelAndView modelAndView = new ModelAndView("accountinfo");
	  modelAndView.addObject("ACCOUNT", account); 
	  return modelAndView; }
	 


}
