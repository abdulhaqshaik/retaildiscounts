package com.retail.discounts.model;

import java.io.Serializable;

public class Bill extends Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6790738589854157182L;
	
	private Integer txn_id;
	
	private double net_payable;
	

	public double getNet_payable() {
		return net_payable;
	}

	public void setNet_payable(double net_payable) {
		this.net_payable = net_payable;
	}

	public Integer getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(Integer txn_id) {
		this.txn_id = txn_id;
	}
	
}
