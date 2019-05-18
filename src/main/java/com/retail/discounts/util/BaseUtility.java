package com.retail.discounts.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.retail.discounts.constant.Constant;
import com.retail.discounts.exception.DiscountException;
import com.retail.discounts.model.Bill;
import com.retail.discounts.model.Customer;
import com.retail.discounts.model.Item;
import com.retail.discounts.model.Transaction;

@Component
public class BaseUtility {
	
	private static final Logger logger = LogManager.getLogger(BaseUtility.class);
	
	public static HashMap<Integer,Customer> customers_list = loadItemsCSV();
	
	public Bill getBill(Transaction txn)
	{
		Bill bill = new Bill();
		bill.setTxn_id(txn.getTxn_id());
		bill.setNet_payable(this.getMaxDiscount(txn));
		bill.setStatus_code(Constant.SUCCESS);
		bill.setStatus_desc("Net Amount generated successfully after discounts");
		return bill;
	}
	
	private Double getMaxDiscount(Transaction txn)
	{
		Double skip_grocery_amt = this.get_amount_skip_grocery(txn.getList());
		Double total_amt = this.get_amount_with_grocery(txn.getList());
		Double non_grocery_amt = total_amt-skip_grocery_amt;
		Double discounted = 0.00;
		//1. If customer is an Employee, then 30% discount + $5 for every $100 on bill
		if(customers_list.get(txn.getCustomer_id())!=null)
		{
		if(customers_list.get(txn.getCustomer_id()).getIsEmployee())
		{	
			logger.debug("Customer is an Employee, So 30% discount on non-groceries.. + common $5 discount for every $100 on bill ");
			discounted = skip_grocery_amt -(skip_grocery_amt*30/100);
			discounted = discounted + non_grocery_amt;
			discounted = discounted - (discounted.intValue()/100*5);
		}
		//2. if customer is an affiliate, then 10% discount +  $5 for every $100 on bill
		else if(customers_list.get(txn.getCustomer_id()).getIsAffliate())
		{	
			logger.debug("Customer is an Affiliate, So 10% discount on non-groceries.. + common $5 discount for every $100 on bill ");
			discounted = skip_grocery_amt -(skip_grocery_amt*10/100);
			discounted = discounted + non_grocery_amt;
			discounted = discounted - (discounted.intValue()/100*5);
		}
		//3. if customer is more than 2 years, then 5% discount +  $5 for every $100 on bill
		else if(customers_list.get(txn.getCustomer_id()).getIs2yearsOld())
		{	
			logger.debug("Customer is 2 years old to the retail store, So 5% discount on non-groceries.. + common $5 discount for every $100 on bill ");
			discounted = skip_grocery_amt -(skip_grocery_amt*5/100);
			discounted = discounted + non_grocery_amt;
			discounted = discounted - (discounted.intValue()/100*5);
		}
		else
		{	
			logger.debug("Some other customer which doesnt have any information in the system (or) Bill less than $100");
			throw new DiscountException("Some other customer which doesnt have any information in the system (or) Bill less than $100");
		}
		}
		else
		{
			logger.debug("Customer is New, So common $5 discount for every $100 on bill ");
			discounted = total_amt - (total_amt.intValue()/100*5);
		}
		return discounted;
	}
	
	private Double get_amount_with_grocery(ArrayList<Item> list)
	{
		Double tot_amount_with_grocery = 0.00;
		for(Item item : list)
		{
			tot_amount_with_grocery = tot_amount_with_grocery+item.getPrice();
		}
		return tot_amount_with_grocery;
	}
	
	private Double get_amount_skip_grocery(ArrayList<Item> list)
	{
		Double tot_amount_skip_grocery = 0.00;
		for(Item item : list)
		{	if(!item.getGrocery())
			tot_amount_skip_grocery = tot_amount_skip_grocery+item.getPrice();
		}
		return tot_amount_skip_grocery;
	}
	
	
	private static HashMap<Integer,Customer> loadItemsCSV() {
        HashMap<Integer,Customer> hmap = new HashMap<Integer, Customer>();
        Customer customer = null;
        Calendar old = Calendar.getInstance();
		old.add(Calendar.YEAR,-2);
		Calendar doj = Calendar.getInstance();
		Date dojDate = null;
		
        Path pathToFile = Paths.get("customer.txt");

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] csvline = line.split(",");
              //1,Abdul,true,true,01-01-2019
                try {
        			dojDate = new SimpleDateFormat("dd-MM-yyyy").parse(csvline[4]);
        		} catch (ParseException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		doj.setTime(dojDate);
        		System.out.println(old.before(doj));
                
                customer = new Customer(Integer.parseInt(csvline[0]),csvline[1],Boolean.parseBoolean(csvline[2]),Boolean.parseBoolean(csvline[3]),csvline[4],old.before(doj));
                hmap.put(customer.getId(), customer);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return hmap;
       
    }
		
}
