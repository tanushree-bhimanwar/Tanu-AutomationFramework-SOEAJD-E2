package Vtiger.practise;

import org.testng.annotations.Test;

public class TestNGPractiseInvoke {
	
	
@Test(invocationCount = 3, priority=1)
		public void createCustomer()
		{
			System.out.println("Customer created");
		}
		
		@Test
		public void modifyCustomer()
		{
			System.out.println("Modify customer");
		}

		@Test
		
			public void deleteCustomer()
			{
				System.out.println("Delete customer");
			}
		
	}


