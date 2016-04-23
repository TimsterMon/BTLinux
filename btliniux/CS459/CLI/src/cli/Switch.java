// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.ProcessList;
import os.Program;

public class Switch extends CliCommand{
	Program classInstance;
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		try{
		list = batch.find(args[0]);
		String name = list.getName();
		return name;
		}catch(Throwable t){return "Batch not found";}
	}
}