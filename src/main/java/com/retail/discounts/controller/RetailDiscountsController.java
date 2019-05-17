package com.retail.discounts.controller;
/*
 * Author :  Abdul Haq Shaik
 * */
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Transaction;
import com.retail.discounts.service.NetAmountServiceImpl;

@RestController
@RequestMapping(value="/amount")
public class RetailDiscountsController {

	private static final Logger logger = LogManager.getLogger(RetailDiscountsController.class);
	
	@Autowired
	NetAmountServiceImpl netAmountService;
	
	@RequestMapping(value="/net", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<Bill> getNetAmount(@RequestBody Transaction txn)
	{
		logger.debug("Sending the transation from the POS Machine to the Discount Calculator");
		Bill bill  = netAmountService.getBill(txn);
		logger.debug("Getting the transation from the Discount Calculator and sending to POS Machine");
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	}
}
