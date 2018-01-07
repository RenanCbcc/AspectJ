package server;

public class Common extends Account {

	private int transaction; 
	private static final int FREE_TRANSACTIONS = 2;
	private static final double TRANSACTION_FEE = 2.0;
	
	public Common(String name, int id) {
		super(name, id);
		
	}

}
