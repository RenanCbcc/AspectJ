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
		if (user.isEmpty() && pass.isEmpty()) {
			System.out.println("Username :");
			user = in.nextLine();
			System.out.println("Password :");
			pass = in.nextLine();
		}
	}

}
