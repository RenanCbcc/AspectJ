package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exception.InsufficientBalanceException;
import exception.RunningOutOfCashException;
import server.Bank;

public class CashMachine {
	private Bank service = null;
	private int available;
	private final int MAX_CASH = 10000;
	private double value;
	String[] options = { "LogIn", "Setting up a Bank Account", "Making a Deposit", "Making a Withdrawal",
			"Transferring Money", "Canceling an Account", "LogOut" };

	public CashMachine(Bank service) {
		this.service = service;

	}

	private void settingUpAccout() throws RemoteException {
		String str = JOptionPane.showInputDialog(null, "What is your name?", "new Account", 0);
		service.settingUpAccout(str, service.getNewId() + 1);
	}

	private void makingaDeposit() throws NumberFormatException, RemoteException {
		String str = JOptionPane.showInputDialog(null, "How much would you like to deposit?", "new Deposit", 0);
		value = Double.parseDouble(str.trim());
		str = JOptionPane.showInputDialog(null, "What is the ID?", "new Deposit", 0);
		service.makingaDeposit(Integer.parseInt(str.trim()), value);
	}

	private void makingaWithdrawal()
			throws NumberFormatException, RemoteException, InsufficientBalanceException, RunningOutOfCashException {
		String str = JOptionPane.showInputDialog(null, "How much would you like to take out?", "new Withdrawal", 0);
		value = Double.parseDouble(str.trim());
		if (value > available) {
			throw new RunningOutOfCashException("You can only withdraw: " + available);
		}
		str = JOptionPane.showInputDialog(null, "What is the ID?", "new Deposit", 0);
		service.makingaWithdrawal(Integer.parseInt(str.trim()), value);
	}

	private void transferringMoney() throws NumberFormatException, RemoteException, InsufficientBalanceException {
		String str = JOptionPane.showInputDialog(null, "How much would you like to transfer?", "new Transferrence", 0);
		value = Double.parseDouble(str.trim());
		str = JOptionPane.showInputDialog(null, "What is the ID?", "new Deposit", 0);
		String id = JOptionPane.showInputDialog(null, "What is youthe ID?", "new Deposit", 0);
		service.transferringMoney(Integer.parseInt(str.trim()), Integer.parseInt(id.trim()), value);
	}

	private void cancelingAnAccout() throws NumberFormatException, RemoteException {
		String str = JOptionPane.showInputDialog(null, "How much would you like to transfer?", "new Transferrence", 0);
		value = Double.parseDouble(str.trim());
		str = JOptionPane.showInputDialog(null, "What is the ID?", "Canceling An Accout", 0);
		service.cancelingAnAccout(Integer.parseInt(str.trim()));
	}

	public void show()
			throws NumberFormatException, RemoteException, InsufficientBalanceException, RunningOutOfCashException {
		String choise = (String) JOptionPane.showInputDialog(new JFrame(), "Select a option !!!", "Welcome!",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		while (true) {
			switch (choise) {

			case "LogIn":
				JOptionPane.showMessageDialog(new JFrame(), "GoodBy");
				break;

			case "Setting up a Bank Account":
				settingUpAccout();
				break;

			case "Making a Deposit":
				makingaDeposit();

				break;

			case "Making a Withdrawal":
				makingaWithdrawal();
				break;

			case "Transferring Money":
				transferringMoney();
				break;

			case "Canceling an Account":
				cancelingAnAccout();
				break;

			case "LogOut":
				JOptionPane.showMessageDialog(new JFrame(), "GoodBye");
				System.exit(0);
				System.out.println("Last accessed time for messageCommunicator " + getLastAccessedTime());
			}
		}

	}

	public static void main(String[] args) throws InsufficientBalanceException, RemoteException, NotBoundException,
			NumberFormatException, RunningOutOfCashException {
		Registry registry = LocateRegistry.getRegistry(1984);
		new CashMachine((Bank) registry.lookup("manager")).show();

	}
}