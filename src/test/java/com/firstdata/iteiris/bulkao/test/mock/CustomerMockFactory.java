package com.firstdata.iteiris.bulkao.test.mock;


import com.firstdata.iteiris.bulkao.pojo.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerMockFactory {
	
	public static List<Customer> createCustomersMockList() {
		List<Customer> customers = new ArrayList<>();
		{
			Customer cust = new Customer();
			cust.setId(98456L); 
			cust.setName("Axel Rose"); 
			cust.setEmail("axl@thehost.com");
			customers.add(cust);
		}
		{
			Customer cust = new Customer();
			cust.setId(65478L); 
			cust.setName("Bono Vox"); 
			cust.setEmail("bono@thehost.com");
			customers.add(cust);
		}
		{
			Customer cust = new Customer();
			cust.setId(78425L); 
			cust.setName("Bob Marley"); 
			cust.setEmail("marley@thehost.com");
			customers.add(cust);
		}
		return customers;
	}

}
