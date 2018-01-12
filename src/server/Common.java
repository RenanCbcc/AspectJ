package server;

public class Common extends Account {

	private int transaction; 
	private static final int FREE_TRANSACTIONS = 2;
	private static final double TRANSACTION_FEE = 2.0;
	
	public Common(String name, int id) {
		super(name, id);
		
	}

	public int getTransaction() {
		return transaction;
	}

	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}

	public static int getFreeTransactions() {
		return FREE_TRANSACTIONS;
	}

	public static double getTransactionFee() {
		return TRANSACTION_FEE;
	}

}
