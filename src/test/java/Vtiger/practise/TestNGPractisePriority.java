package Vtiger.practise;

import org.testng.annotations.Test;

public class TestNGPractisePriority {
	@Test(priority = 1)
	public void createCustomer()
	{
		System.out.println("Customer created");
	}
	
	@Test(priority=2)
	public void modifyCustomer()
	{
		System.out.println("Modify customer");
	}

	@Test(priority=3)
	
		public void deleteCustomer()
		{
			System.out.println("Delete customer");
		}
	
}
