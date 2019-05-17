package com.retail.discounts.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Item;
import com.retail.discounts.model.Transaction;
import com.retail.discounts.service.NetAmountServiceImpl;

import java.util.ArrayList;

import org.junit.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class RetailDiscountsControllerTest {

	@Mock
	NetAmountServiceImpl netsrvimpl;
	
	@InjectMocks
	RetailDiscountsController controller = new RetailDiscountsController();
	
	private Bill bill;
	private Transaction txn;
	private Item item;
	
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
		
		txn = new Transaction(1,"25-04-2019",1,arList);
		
	}
	
	@Test
	public void testGetNetAmount() throws Exception {
	Mockito.when(netsrvimpl.getBill(txn)).thenReturn(bill);
	ResponseEntity<Bill> response = controller.getNetAmount(txn);
	Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}