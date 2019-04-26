package com.ewallet.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class CreateAccount {
	
	
	@Id
	@SequenceGenerator(name="seq",sequenceName="ACCNO_SEQ", allocationSize=1, initialValue=100)
	@GeneratedValue(generator ="seq",strategy=GenerationType.SEQUENCE)
	@Column(name="AccNo")
	private Long accNo;
	//private List<Transaction> transaction;
	@Column(name="FName")
	private String fName;
	@Column(name="LName")
	private String lName;
	@Column(name="Email")
	private String email;
	@Column(name="Mobile")
	private long phone;
	@Column(name="Pasword")
	private String password;
	
	private String cPassword;
	@Column(name="Balance")
	private double balance;
	
	
	public CreateAccount() {
		super();
	}
	
	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "CreateAccount [accNo=" + accNo + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", cPassword=" + cPassword + ", balance=" + balance
				+ "]";
	}
	
	
	
}
