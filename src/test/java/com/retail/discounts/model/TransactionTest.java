package com.retail.discounts.model;

import org.junit.*;

public class TransactionTest {
	
	private Transaction txn;

	@Before
	public void setUp() throws Exception {
		
		txn = new Transaction(2, "25-04-2019", 2, null);
	}
	
	@Test
	public void testtxn()
	{
		Assert.assertEquals(2, txn.getTxn_id());
		Assert.assertEquals(2, txn.getCustomer_id());
		Assert.assertEquals(null, txn.getList());
		Assert.assertEquals("25-04-2019",txn.getTxn_date());
	}

	@After
	public void destroy()
	{
		txn = null;
	}

}
