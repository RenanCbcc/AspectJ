package client;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.InsufficientBalanceException;
import server.Manager;

public class Test {
	static JFrame frame = new JFrame();
	 static double value;
	
	public static void main(String[] args) throws InsufficientBalanceException, RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(1984);
		Manager manager = (Manager) registry.lookup("manager");
		String str;
		String[] options = {"Setting up a Bank Account", "Making a Deposit", "Making a Withdrawal", "Transferring Money","Canceling an Account","Exit"};
		
		//str = JOptionPane.showInputDialog(null, "Senha");
		
		while(true)
        {
        	String choise = (String) JOptionPane.showInputDialog(frame, "Select a option !!!", "Welcome!", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        	if (choise == null) 
        	{
        		choise = "0";
        	}
        	switch (choise)  
        	{
            	case "Setting up a Bank Account":
            		str = JOptionPane.showInputDialog(null, "What is your name?","new Account",0);
            		manager.settingUpAccout(str, manager.getNewId()+1);
            		break;
            		
            	case "Making a Deposit":
            		str = JOptionPane.showInputDialog(null, "How much would you like to deposit?","new Deposit",0);
            		value = Double.parseDouble(str.trim());
            		str = JOptionPane.showInputDialog(null, "What is the ID?","new Deposit",0);
            		manager.makingaDeposit(Integer.parseInt( str.trim()  ), value);
            		
            		break;
            	
            	case "Making a Withdrawal":
            		str = JOptionPane.showInputDialog(null, "How much would you like to take out?","new Withdrawal",0);
            		value = Double.parseDouble(str.trim());
            		str = JOptionPane.showInputDialog(null, "What is the ID?","new Deposit",0);
            		manager.makingaWithdrawal(Integer.parseInt( str.trim()  ), value);
            		break;
             
            	case "Transferring Money":
            		str = JOptionPane.showInputDialog(null, "How much would you like to transfer?","new Transferrence",0);
            		value = Double.parseDouble(str.trim());
            		str = JOptionPane.showInputDialog(null, "What is the ID?","new Deposit",0);
            		String id = JOptionPane.showInputDialog(null, "What is youthe ID?","new Deposit",0);
            		manager.transferringMoney(Integer.parseInt( str.trim()  ),Integer.parseInt( id.trim()  ), value);
            		break;
            		
            	case "Canceling an Account":
            		str = JOptionPane.showInputDialog(null, "How much would you like to transfer?","new Transferrence",0);
            		value = Double.parseDouble(str.trim());
            		str = JOptionPane.showInputDialog(null, "What is the ID?","new Deposit",0);
            		id = JOptionPane.showInputDialog(null, "What is youthe ID?","new Deposit",0);
            		manager.transferringMoney(Integer.parseInt( str.trim()  ),Integer.parseInt( id.trim()  ), value);
            		break;
            		
            	case "Sair":
            		JOptionPane.showMessageDialog(frame, "adeus ");
            		System.exit(0);
        	}
        
        }
		
		
	}
}