package os;

public class MaxTime implements Runnable {
	BatchThread bThread;
	int doze;

	public MaxTime(BatchThread bThread, int doze){
		this.bThread = bThread;
		if(doze < 0){
			this.doze = -1;
		} else if(doze == 0){
			// exit
		} else {
			this.doze = doze;
		}
	}

	@Override
	public void run() {
		// runs at Thread.MAX_PRIORITY
		// sleeps for batch time run limit (if non-zero)
		// otherwise it just exits
		/*
		 	
		 sleep(doze);
		 interrupt(bThread);
		 
		 
		 */
		
		
	}
}
