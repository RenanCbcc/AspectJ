package exceptions;

public class AccountNotFoundException extends Exception{
	
	private static final long serialVersionUID = -3408961152801872021L;

	public AccountNotFoundException(String message)
	{
		super(message);
	}
}
