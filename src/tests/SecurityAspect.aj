package tests;

import java.util.Scanner;

import server.Account;

public aspect SecurityAspect {
	private Authenticator authenticator = new Authenticator();
	
	declare warning
	: call(void Authenticator.authenticate()) && !within(SecurityAspect)
	: "Authentication should be performed only by SecurityAspect";

	pointcut secureAccess()
	: execution(* MessageCommunicator.deliver(..));

	pointcut secureTransference()
	: execution(* Account.transfer(..));

	pointcut secureWithdraw()
	: execution(* Account.withdraw(..));

	before() : secureAccess() {
		System.out.println("Checking and authenticating user");
		authenticator.authenticate();
	}

	before() : secureTransference() {
		System.out.println("Checking and authenticating user");
		System.out.println("Enter you password to conclude the transaction:");
		authenticator.authenticate();
	}

	before() : secureWithdraw() {
		System.out.println("Checking and authenticating user");
		System.out.println("Enter you password to conclude the transaction:");
		System.out.println("Password :");
		Scanner in = new Scanner(System.in);
		authenticator.authenticate(in.nextLine());
		in.close();
	}
}
