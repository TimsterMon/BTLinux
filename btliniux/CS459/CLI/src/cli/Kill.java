// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.Process;
import os.ProcessList;
import os.Program;

public class Kill extends CliCommand{
	Program classInstance;

	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		 try{
		 list = batch.remove(args[0]);
		 if(list == null) return "Batch not found";
		 }catch(Throwable t){return "Batch not found";}
		 return args[0] + " removed";
	}
}

