package pacote;
import javax.swing.JOptionPane;

public aspect ExceptionAspect {
	
	
	pointcut accountOperatio ():call(void Account.Debit(..));
	pointcut accountPassword():call(void Account.setpassword(..));
	
	after() throwing (InsufficientBalanceException ibe): 
		call(void Account.*(..)) 
		{
		
		 JOptionPane.showMessageDialog(null,ibe.getMessage(),"Erro",0);
		 System.exit(0);
		}
	
	after() throwing (IllegalArgumentException iae): 
		call(void Account.*(..)) 
		{
		String str = "Senha inválida"; 
		JOptionPane.showMessageDialog(null,str,iae.getMessage(),0);
		 System.exit(0);
		}
	
}
