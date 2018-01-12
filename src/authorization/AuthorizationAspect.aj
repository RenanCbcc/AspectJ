package authorization;

import server.Account;

public aspect AuthorizationAspect {

	public pointcut permission(Account account):call(* Account.withdraw(..))  && target(account);
	
	
}
