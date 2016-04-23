// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.ProcessList;

public class New extends CliCommand{
	
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		String name = args[0];
		
        if(batch.find(name) != null) { return "Batch already exists";} 

		
		return name + " initialized";
	}
	
}
