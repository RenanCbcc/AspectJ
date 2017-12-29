package report;

import server.Account;

public aspect ReportAspect {

	pointcut generateReport(): set(private double Account.balance);
	
	
	after():generateReport(){
		System.out.println("Transaction performed with sucsses");
	}
}
