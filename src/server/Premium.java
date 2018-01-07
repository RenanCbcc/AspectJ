package server;

public class Premium extends Account {
	
	private int transaction; 
	private static final int FREE_TRANSACTIONS = 10;
	private static final double TRANSACTION_FEE = 2.0;
	
	public Premium(String name, int id) {
		super(name, id);
		
	}

}
