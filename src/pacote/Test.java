package pacote;

public class Test {
	public static void main(String[] args) throws InsufficientBalanceException {
		SavingsAccount account = new SavingsAccount(12456);
		account.credit(100);
		account.debit(50);
	}
}