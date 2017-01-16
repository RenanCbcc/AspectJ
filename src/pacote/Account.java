package pacote;
import pacote.InsufficientBalanceException;
public abstract class Account {
	private int balance;
	private int accountNumber;
	private int password;
	
	
	public Account(int accountNumber) {
		accountNumber = accountNumber;
	}
	
	
	public void credit(String amount)throws IllegalArgumentException{
		int number = Integer.parseInt(amount);  
		setBalance(getBalance() + number);
	}

	public void debit(int amount) throws InsufficientBalanceException 
	{
		int balance = getBalance();
		
		if (balance < amount) 
		{
			throw new InsufficientBalanceException("Total balance not sufficient");
		} 
		else 
		{
			setBalance(balance - amount);
		}
	}

	public void setpassword(String str) throws NumberFormatException
	{
		int number = Integer.parseInt(str);
		password = number;
        
	}
	
	public int getBalance() {
		return balance;
	}

	
	public void setBalance(int value) {
		balance = value;
	}
}