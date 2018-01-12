package exception;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public aspect ExeceptionAspect {

	public pointcut RemoteExceptionPoint() : execution(* *.*(..) throws
			RemoteException);

	public pointcut NumberFormatExceptionPoint() : execution(* *.*(..) throws
			NumberFormatException);

	after() throwing (RemoteException nfe): RemoteExceptionPoint(){
		JOptionPane.showMessageDialog(null, nfe.getMessage(), "Erro", 0);
	}
	
	after() throwing (NumberFormatException nfe): NumberFormatExceptionPoint(){
		JOptionPane.showMessageDialog(null, nfe.getMessage(), "Erro", 0);
	}


}
