// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.Process;
import os.ProcessList;
import os.Program;

public class Add extends CliCommand{
	Program classInstance;
	@Override
	//execute method
	public String execute(String[] args, ProcessList list, BatchList batch) {
		Process p;
		long pid = System.currentTimeMillis() % 100000;
		int priority = Thread.NORM_PRIORITY;	
		try{
			@SuppressWarnings("rawtypes")
			 Class className = Class.forName("programs." + args[0]);
	         classInstance = (Program)className.newInstance();
			 p = new Process(args, priority, pid);
			 list.enQueue(p); // add process
			 
		}catch(Exception e){
		 if(list == null) return "No batch has been initalized"; //check if list initialized
		 else return "Class not found"; // invalid class
		 }
		
		return "process " + args[0] + " was added to batch"; // success
	}

}
