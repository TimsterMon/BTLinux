// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.ProcessList;

public class Remove extends CliCommand{
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
			os.Process p = list.remove(Long.parseLong(args[0]));
			if(p == null) return "ID not found";
			
		return "Process " + args[0] + " was deleted sucessfully";
	}
}
