import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount obj = new BankAccount("XYZ", "BA0001");
		obj.showMenu();
	}

}

class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cusName, String cusId)
	{
		customerName = cusName;
		customerId = cusId;
	}
	
	void deposit(int amount)
	{
		if (amount != 0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount)
	{
		if (amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction()
	{
		if (previousTransaction > 0)
		{
			System.out.println("Deposited: " + previousTransaction);
		}
		else if (previousTransaction < 0)
		{
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu()
	{
		// Show or display the menu in front of the user
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do // a do, while loop. Basically just tells it to loop through while the option entered isn't what we tell it to be, in this case 'E'
		{
			System.out.println("================================================================================================");
			System.out.println("Enter an option");
			System.out.println("================================================================================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'A':
				System.out.println("-------------------------------------------");
				System.out.println("Balance = " + balance);
				System.out.println("-------------------------------------------");
				System.out.println("\n");
				break;
			
			case 'B':
				System.out.println("-------------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("-------------------------------------------");
				int depositAmount = scanner.nextInt();
				deposit(depositAmount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("-------------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("-------------------------------------------");
				int withdrawAmount = scanner.nextInt();
				withdraw(withdrawAmount);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("-------------------------------------------");
				getPreviousTransaction();
				System.out.println("-------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("-------------------------------------------");
				break;
				
			default: 
				System.out.println("Invalid Option! Please only enter one of the given options!");
				break;
				
			}
		} while(option != 'E');
		
		System.out.println("Thank you for using our services!");
	}
}