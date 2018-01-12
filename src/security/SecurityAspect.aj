package security;

import java.util.Scanner;

import server.Account;

public aspect SecurityAspect {
	private Scanner in;
	private String user, pass;

	pointcut secureLogIn()
	: call(* Account.logIn());

	/**
	 * When advice needs the join point context, you must use pointcuts to bind
	 * each argument to a join point context.
	 * 
	 * @param account
	 */
	pointcut secureTransference(Account account)
	: call(* Account.transfer(..)) && target(account);

	/**
	 * The matched pointcuts are implicitly restricted to an equivalent pointcut
	 * that uses the type of the object identifier specified. This restricts any
	 * matching to join points, where the target object is of the Account.
	 * 
	 * @param account
	 */

	pointcut secureWithdraw(Account account)
	: call(* Account.withdraw(..))  && target(account);

	before(Account account) : secureTransference(account) {
		System.out.println("Checking and authenticating user");
		System.out.println("Enter you password to conclude the transaction:");
		Scanner in = new Scanner(System.in);
		authenticate(in.nextLine(), account);
		in.close();
	}

	before(Account account) : secureWithdraw(account) {
		System.out.println("Checking and authenticating user");
		System.out.println("Enter you password to conclude the transaction:");
		System.out.println("Password :");
		Scanner in = new Scanner(System.in);
		authenticate(in.nextLine(), account);
		in.close();
	}

	before(): secureLogIn(){
		authenticate();
	}

	public void authenticate() {
		if (isAuthenticated()) {
			System.out.println("Username :");
			setUser(in.nextLine());
			System.out.println("Password :");
			setPass(in.nextLine());
		}
	}

	public void authenticate(String pass, Account account) {
		if (isAuthenticated(pass)) {
			System.out.println("AcKnowledgment");
		}
		System.out.println("Deniede");
	}

	private boolean isAuthenticated() {
		if (user.isEmpty() && pass.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	private boolean isAuthenticated(String pass) {
		if (!pass.isEmpty() && pass.equals(pass)) {
			return true;
		} else {
			return false;
		}
	}

}
