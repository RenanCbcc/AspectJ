package tests;

import java.util.Scanner;

public class Authenticator {
	private Scanner in;
	private String user, pass;

	public Authenticator() {
		this.user = "";
		this.pass = "";
		in = new Scanner(System.in);
	}

	public void authenticate() {
		if (isAuthenticated()) {
			System.out.println("Username :");
			user = in.nextLine();
			System.out.println("Password :");
			pass = in.nextLine();
		}
	}

	public void authenticate(String pass) {
		if (isAuthenticated(pass)) {
			System.out.println("AcKnowledgment");
		}
		System.out.println("Denide");
	}

	private boolean isAuthenticated() {
		if (user.isEmpty() && pass.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isAuthenticated(String pass) {
		if (!pass.isEmpty() && pass.equals(pass)) {
			return true;
		} else {
			return false;
		}
	}

}
