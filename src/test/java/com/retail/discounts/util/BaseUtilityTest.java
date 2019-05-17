package com.retail.discounts.util;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Item;
import com.retail.discounts.model.Transaction;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class BaseUtilityTest {

	private Bill bill;
	private Item item;
	private Transaction txn;
	
	@InjectMocks
	BaseUtility baseutil;
	
	
	
	@Before
	public void setUp() throws Exception {
		bill = new Bill();
		bill.setNet_payable(770.00);
		bill.setStatus_code("SUCCESS");
		bill.setStatus_desc("SUCCESSFUL");
		bill.setTxn_id(1);
		
		item = new Item(1,"Wheat",200.00,true);
		ArrayList<Item> arList = new ArrayList<Item>();
		arList.add(item);
		
		txn = new Transaction(1,"25-04-2019",1,arList);
	}

	@Test
	public void testBill() {
		
		Bill bill = baseutil.getBill(txn);
		Assert.assertEquals("SUCCESS", bill.getStatus_code());
		
			
	}

}
