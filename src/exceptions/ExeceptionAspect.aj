package exceptions;

import java.rmi.RemoteException;

public aspect ExeceptionAspect {
	
	

	pointcut RemoteExceptionPoint() : call(* *.*(..) throws
			RemoteException);
	
	
	

}
