package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.InsufficientBalanceException;
import interfaces.Messenger;

public final class Bank extends UnicastRemoteObject implements Messenger {

	private static Messenger instance = null;
	private HashMap<Integer, Account> accounts;
	private final String name = "Midas Back";

	protected Bank() throws RemoteException {
		super();
		accounts = new HashMap<Integer, Account>();
	}

	private static final long serialVersionUID = -4674037397344726011L;

	@Override
	public boolean settingUpAccout(String name, int id) throws RemoteException {
		if (accounts.containsKey(id)) {
			return false;
		}

		String[] options = { "Common", "Premium", "Savings Account" };
		String choise = (String) JOptionPane.showInputDialog(new JFrame(), "Select a option !!!", "Welcome!",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		switch (choise) {
		case "Common":
			accounts.put(id, new Common(name, id));
			break;
		case "Premium":
			accounts.put(id, new Premium(name, id));
			break;
		case "Savings Account":
			accounts.put(id, new SavingsAccount(name, id));
			break;
		}

		return true;
	}

	@Override
	public boolean cancelingAnAccout(int id) throws RemoteException {
		if (accounts.containsKey(id)) {
			accounts.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean makingaWithdrawal(int id, double value) throws RemoteException, InsufficientBalanceException {
		if (accounts.containsKey(id)) {
			accounts.get(id).withdraw(value);
			return true;
		}
		return false;
	}

	@Override
	public boolean transferringMoney(int firstId, int secondId, double value)
			throws RemoteException, InsufficientBalanceException {
		if (accounts.containsKey(firstId) && accounts.containsKey(secondId)) {
			return accounts.get(firstId).transfer(value, accounts.get(secondId));
		}
		return false;
	}

	@Override
	public boolean makingaDeposit(int id, double value) throws RemoteException {
		if (accounts.containsKey(id)) {
			accounts.get(id).deposit(value);
			return true;
		}
		return false;
	}

	public static Messenger getInstance() throws RemoteException {
		if (instance == null) {
			instance = new Bank();

		}

		return instance;
	}

	public int getNewId() {
		return accounts.size();
	}
	
	public String name(){
		return name;
	}
}
