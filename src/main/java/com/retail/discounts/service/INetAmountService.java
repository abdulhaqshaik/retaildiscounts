package com.retail.discounts.service;

import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Transaction;

public interface INetAmountService {
	
	public Bill getBill(Transaction txn);

}
