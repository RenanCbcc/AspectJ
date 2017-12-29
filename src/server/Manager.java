package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import exceptions.InsufficientBalanceException;
import interfaces.Messenger;

public final class Manager extends UnicastRemoteObject implements Messenger {
	
	 
	private static Messenger instance = null;
	private HashMap<Integer, Account> accounts;

	protected Manager() throws RemoteException {
		super();
		accounts = new HashMap<Integer, Account>();
	}

	private static final long serialVersionUID = -4674037397344726011L;

	@Override
	public boolean settingUpAccout(String name, int id) throws RemoteException {
		if (accounts.containsKey(id)) {
			return false;
		}
		accounts.put(id, new Account(name, id));
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
			instance = new Manager();

		}

		return instance;
	}
	
	public int getNewId(){
		return accounts.size();
	}
}
