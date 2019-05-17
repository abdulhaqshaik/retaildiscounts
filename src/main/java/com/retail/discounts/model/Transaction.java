package com.retail.discounts.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4328138675909453552L;
	
	public Transaction(int f_txn_id, String f_txn_date, int f_customer_id,ArrayList<Item> f_list)
	{
		this.customer_id = f_customer_id;
		this.list=f_list;
		this.txn_date=f_txn_date;
		this.txn_id=f_txn_id;
	}

	private int txn_id;
	
	private String txn_date;
	
	private int customer_id;
	
	private ArrayList<Item> list;
	
	
	public int getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(int txn_id) {
		this.txn_id = txn_id;
	}

	public String getTxn_date() {
		return txn_date;
	}

	public void setTxn_date(String txn_date) {
		this.txn_date = txn_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public ArrayList<Item> getList() {
		return list;
	}

	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	
}
