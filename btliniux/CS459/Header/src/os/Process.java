package os;
import java.io.*;

public class Process implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int RUNNING		= 0;
	public static final int WAIT		= 1;
	public static final int IDLE		= 2;
	public static final int TERMINATED	= 3;
	public static final int ABORTED		= 4;
	
	private String[] args;		// calling arguments
	private long id;			// pid
	private int priority;		// priority
	private long startTime;		// process start time
	private long endTime;		// end time aft process completes
	private int status;			// status
	
	@SuppressWarnings("rawtypes")
	Class className;			// bytecode name of class
	Program classInstance;		// class instance that can be called
	
	public Process next;
	public Process previous;
	// constructor
	public Process(String[] args, int priority, long id)throws ClassNotFoundException, IOException{
		this.args = args;
		this.id = id;
		this.priority = priority;
		this.status = 2;
		this.startTime = 0;
		this.endTime = 0;
		next = null;
		previous = null;
	}
	public String run(PrintWriter out, File file) throws InstantiationException, IllegalAccessException, InterruptedException{	
		startTime = System.currentTimeMillis() % 100000;
		StringBuilder builder = new StringBuilder();
		try{
			FileWriter writer = new FileWriter(file, true);
			out = new PrintWriter(writer);
			className = Class.forName("programs." + getName());
			classInstance = (Program)className.newInstance();
			int result = classInstance.run(out, args);
			if(result == 1){
				this.status = 4;
				builder.append(getName() + " did not run successfully \n");
			} else{
				this.status = 3;
				builder.append(getName() + " ran successfully time = 0 \n");
			}		
		} catch(Throwable t){
			return "Program not found";
		}
		out.close();
		return builder.toString();
	}

	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public long getId(){
		return id;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public String getName(){
		return args[0];
	}
	
	public String[] getArgs(){
		return args;
	}
	
	public long getRunTime(){
		long time;
		if(status>2){
			time = startTime-endTime;
		}else if (status == 2){
			time = 0;
		} else {
			long ttime = System.currentTimeMillis() % 100000;
			time = ttime - startTime;
		}
		return time;
	}
	
	public String getStatus(){
		String state;
		switch(status){
		case RUNNING:
			state = "RUNNING";
			break;
		case WAIT:
			state = "WAIT";
			break;
		case IDLE:
			state = "IDLE";
			break;
		case TERMINATED:
			state = "TERMINATED";
			break;
		case ABORTED:
			state = "ABORTED";
		default:
			state = "ERROR_UNKNOWN_STATE";
		}
		return state;
	}
	
	public String toString(String[] args, int priority, long id ){
		String strin = "";
		for(int i=0;i<args.length;i++){
			strin+=args[i];
			strin+=" ";
		}
		strin+=priority + " " + id + " ";
		return strin;
	}
}