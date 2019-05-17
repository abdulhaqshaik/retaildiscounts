package com.retail.discounts.model;

import org.junit.*;

public class CustomerTest {
	
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer(1, "Abdul", false, true, "01-01-2010", false);
	}
	
	@Test
	public void testCustomer()
	{
		Assert.assertEquals((Integer)1, customer.getId());
		Assert.assertEquals("Abdul", customer.getName());
		Assert.assertEquals(false, customer.getIsEmployee());
		Assert.assertEquals(true, customer.getIsAffliate());
		Assert.assertEquals("01-01-2010", customer.getDoj());
		Assert.assertEquals(false, customer.getIs2yearsOld());
	}

	@After
	public void destroy()
	{
		customer = null;
	}

}
