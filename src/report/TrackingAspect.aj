package report;

import client.CashMachine;
import interfaces.AccessTracked;
import tests.MessageCommunicator;

public aspect TrackingAspect {

	declare parents: MessageCommunicator implements AccessTracked;
	declare parents: CashMachine implements AccessTracked;

	// The above code has the same effect as declaring: MessageCommunicator
	// implements AccessTracked
	private long AccessTracked.lastAccessedTime;

	public void AccessTracked.updateLastAccessedTime() {
		lastAccessedTime = System.currentTimeMillis();
	}

	public long AccessTracked.getLastAccessedTime() {
		return lastAccessedTime;
	}

	before(AccessTracked accessTracked): execution(* AccessTracked+.*(..))
		&& !execution(* AccessTracked.*(..))// but not the method in AccessTracked
			&& this(accessTracked) 
			{
		accessTracked.updateLastAccessedTime();
	}

}