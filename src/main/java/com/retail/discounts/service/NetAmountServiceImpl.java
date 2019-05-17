package com.retail.discounts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.discounts.constant.Constant;
import com.retail.discounts.exception.DiscountException;
import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Transaction;
import com.retail.discounts.util.BaseUtility;

@Service
public class NetAmountServiceImpl implements INetAmountService {
	
	private static final Logger logger = LogManager.getLogger(NetAmountServiceImpl.class);
	
	@Autowired
	BaseUtility baseutil;
	
	
	public Bill getBill(Transaction txn)
	{
		Bill bill = new Bill();
		try
		{
		  bill = baseutil.getBill(txn);
		}
		catch(DiscountException ex)
		{
			logger.debug("The DiscountException occured in NetAmountServiceImpl : "+ex.getMessage());
			bill.setStatus_code(Constant.FAILURE);
			bill.setStatus_desc(ex.getMessage());
		}
		catch(Exception e)
		{
			logger.debug("The Exception occured in NetAmountServiceImpl : "+e.getMessage());
			bill.setStatus_code(Constant.FAILURE);
			bill.setStatus_desc("Net amount generation failed");
		}
		return bill;
	}

}
