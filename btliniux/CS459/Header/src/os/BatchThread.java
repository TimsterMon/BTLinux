package os;

public class BatchThread {
	// instantiate a batch output stream
	MaxTime max;
	ProcessList pL;
	BatchThread b;
	
	public BatchThread(ProcessList pL, int doze){
		Process p = pL.peek();
		this.pL = pL;
		max = new MaxTime(b, doze);
		if(Integer.parseInt(p.getStatus()) > 2){
			//interrupt MaxTime
		}
	}

}
