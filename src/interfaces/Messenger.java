package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exception.InsufficientBalanceException;

public interface Messenger extends Remote{

	boolean settingUpAccout(String name, int id)throws RemoteException;
	boolean cancelingAnAccout(int id)throws RemoteException;
	boolean makingaWithdrawal(int id, double value)throws RemoteException, InsufficientBalanceException;
	boolean transferringMoney(int firstId, int secondeId, double value)throws RemoteException, InsufficientBalanceException;
	boolean makingaDeposit(int id, double value)throws RemoteException;
	
}
