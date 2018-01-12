package exception;

public class InsufficientBalanceException extends Exception {
	
	private static final long serialVersionUID = -8997434351679160937L;

	public InsufficientBalanceException(String message)
	{
		super(message);
	}
}
