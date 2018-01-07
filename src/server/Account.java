package server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import exceptions.InsufficientBalanceException;

public abstract class Account {
	private double balance, limit, withdraw;
	private int id;
	private String user, password;

	public Account(String name, int id) {
		this.user = name;
		this.id = id;
	}

	public void report() {
		Date date = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		System.out.println("----------------------------------------------------");
		System.out.println("| Report " + "client " + user + " " + df.format(date) + " |");
		System.out.println("| Current balance: %2.f" + getBalance() + " |");
		System.out.println("| Withdraws made today: %2.f" + this.withdraw + " |");
		System.out.println("----------------------------------------------------");

	}

	public void logIn() {
		System.out.println("Welcome " + user);
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		double balance = getBalance();

		if (balance < amount) {
			throw new InsufficientBalanceException("Total balance not sufficient");
		} else {
			setBalance(balance - amount);
		}
	}

	public boolean transfer(double value, Account accaunt) throws InsufficientBalanceException {
		if (value > 0) {
			this.withdraw(value);
			accaunt.deposit(value);
			return true;
		}
		return false;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double value) {
		balance = value;
	}

	public void deposit(double value) {
		balance += value;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
