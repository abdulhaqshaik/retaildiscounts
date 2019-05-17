package com.retail.discounts.model;

import org.junit.*;

public class ItemTest {
	
	private Item item;

	@Before
	public void setUp() throws Exception {
		item = new Item(1,"Wheat",200.00,true);
	}
	
	@Test
	public void testitem()
	{
		Assert.assertEquals("Wheat", item.getName());
		Assert.assertEquals(1, item.getId());
		Assert.assertNotEquals(400.00, item.getPrice());
		Assert.assertNotEquals(false,item.getGrocery());
	}

	@After
	public void destroy()
	{
		item = null;
	}

}
