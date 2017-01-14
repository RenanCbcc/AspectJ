package pacote;

public aspect ExceptionAspect {
	
	pointcut accountOperatio ():call(void debit)

}
