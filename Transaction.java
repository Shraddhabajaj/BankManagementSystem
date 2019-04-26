package com.ewallet.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Transaction")
public class Transaction {
	
	@Id
	@SequenceGenerator(name="seq2",sequenceName="TID_SEQ", allocationSize=1, initialValue=100)
	@GeneratedValue(generator ="seq2",strategy=GenerationType.SEQUENCE)
	@Column(name="tid")
	private int tId;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Amount")
	private double amount;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "fromAccNo", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private CreateAccount fromaccount;
	
	@ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "toAccNo", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private CreateAccount toaccount;

	

	public Transaction() {
		super();
	}


	public int gettId() {
		return tId;
	}


	public void settId(int tId) {
		this.tId = tId;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public CreateAccount getFromaccount() {
		return fromaccount;
	}


	public void setFromaccount(CreateAccount fromaccount) {
		this.fromaccount = fromaccount;
	}


	public CreateAccount getToaccount() {
		return toaccount;
	}


	public void setToaccount(CreateAccount toaccount) {
		this.toaccount = toaccount;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", type=" + type + ", amount=" + amount + ", fromaccount=" + fromaccount
				+ ", toaccount=" + toaccount + "]";
	}




	
	

}
