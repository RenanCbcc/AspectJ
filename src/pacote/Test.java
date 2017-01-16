package pacote;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test {
	static JFrame frame = new JFrame();
	 static String str;
	 static int valor;
	
	public static void main(String[] args) throws InsufficientBalanceException {
		String[] option = {"Credit", "Debit", "Balance", "Sair"};
		SavingsAccount account = new SavingsAccount(12456);
		
		str = JOptionPane.showInputDialog(null, "Senha");
		account.setpassword(str);
		
		while(true)
        {
        	String escolha = (String) JOptionPane.showInputDialog(frame, "Escolha uma opcao !!!!", "Bem Vindo!", JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        	if (escolha == null) 
        	{
        		escolha = "0";
        	}
        	switch (escolha)  
        	{
            	case "Credit":
            		str = JOptionPane.showInputDialog(null, "Digite uma valor","Credit",0);
            		 account.credit(str);
            		break;
            		
            	case "Debit":
            		String str = JOptionPane.showInputDialog(null, "Digite uma valor","Debit",0);
            		valor = Integer.parseInt( str.trim()  );
            		account.debit(valor);
            		
            		break;
            	
            	case "Balance":
            		JOptionPane.showMessageDialog(frame, account.getBalance(),"getBalance",0);
            		break;
             
            	case "Sair":
            		JOptionPane.showMessageDialog(frame, "adeus ");
            		System.exit(0);
        	}
        
        }

		
		
	}
}