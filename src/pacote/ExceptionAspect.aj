package pacote;
import javax.swing.JOptionPane;

public aspect ExceptionAspect {
	
	
	public pointcut accountExceptionIBE():call(void Account.*(..));
	public pointcut accountExceptionIAE():call(void Account.*(..));
	public pointcut accountExceptionNFE():call(void Account.*(..));
	
	NumberFormatException
	after() throwing (InsufficientBalanceException ibe): accountExceptionIBE()
		{
		
		 JOptionPane.showMessageDialog(null,ibe.getMessage(),"Erro",0);
		 System.exit(0);
		}
	
	after() throwing (NumberFormatException nfe): accountExceptionIBE()
		{
		
		 JOptionPane.showMessageDialog(null,nfe.getMessage(),"Erro",0);
		 System.exit(0);
		}
	
	after() throwing (IllegalArgumentException iae): accountOperatioIAE() 
		{
		String str = "Senha invalida"; 
		JOptionPane.showMessageDialog(null,iae,iae.getMessage(),0);
		 System.exit(0);
		}
	
}
