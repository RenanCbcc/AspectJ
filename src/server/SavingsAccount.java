package server;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(String name, int id) {
		super(name, id);

	}

	/**
	 * Constructs a bank account with a given interest rate.
	 * 
	 * @param rate
	 *            the interest rate
	 */
	public SavingsAccount(String name, int id, double rate) {
		super(name, id);
		interestRate = rate;
	}

	/**
	 * Adds the earned interest to the account balance.
	 */
	public void addInterest() {
		double interest = getBalance() * interestRate / 100;
		deposit(interest);
	}

}
