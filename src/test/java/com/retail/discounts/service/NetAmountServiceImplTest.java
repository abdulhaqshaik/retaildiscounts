package com.retail.discounts.service;


import java.util.ArrayList;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import com.retail.discounts.exception.DiscountException;
import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Item;
import com.retail.discounts.model.Transaction;
import com.retail.discounts.util.BaseUtility;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class NetAmountServiceImplTest {

	private Bill bill;
	private Transaction txn;
	private Item item;
	
	@Mock
	BaseUtility baseutil;
	
	@InjectMocks
	NetAmountServiceImpl service = new NetAmountServiceImpl();
	
	@Before
	public void setup()
	{
		bill = new Bill();
		bill.setNet_payable(200.00);
		bill.setStatus_code("SUCCESS");
		bill.setStatus_desc("SUCCESSFUL");
		bill.setTxn_id(1);
		
		item = new Item(1,"Wheat",200.00,true);
		ArrayList<Item> arList = new ArrayList<Item>();
		arList.add(item);
		
		txn = new Transaction(2, "25-04-2019", 2, arList);
		
	}
	
	@Test
	public void testGetBill() throws DiscountException,Exception {
		
		Mockito.when(baseutil.getBill(txn)).thenReturn(bill);
		Bill bill = service.getBill(txn);
		Assert.assertEquals("SUCCESS", bill.getStatus_code());
		
	}
}