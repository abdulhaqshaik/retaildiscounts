package com.retail.discounts.model;

import org.junit.*;

public class BillTest {
	
	private Bill bill;

	@Before
	public void setUp() throws Exception {
		bill = new Bill();
		bill.setNet_payable(200.00);
		bill.setStatus_code("SUCCESS");
		bill.setStatus_desc("SUCCESSFUL");
		bill.setTxn_id(1);
		
	}
	
	@Test
	public void testBill()
	{
		Assert.assertEquals("SUCCESS", bill.getStatus_code());
		Assert.assertEquals("SUCCESSFUL", bill.getStatus_desc());
		Assert.assertNotEquals((Double)400.00, bill.getNet_payable());
		Assert.assertNotEquals((Integer)2,bill.getTxn_id());
	}

	@After
	public void destroy()
	{
		bill = null;
	}

}
