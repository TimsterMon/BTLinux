// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.Process;
import os.ProcessList;

public class Priority extends CliCommand{

	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		Process p;
		long id = Long.parseLong(args[0]);
		int priority = Integer.parseInt(args[1]);
		p = list.find(id);	
			if(p == null)
				return "Id not found";
			else if(priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY - 1)
				return "Priority must be between 1 and 9";
			else 
				list.setPriority(id, priority);
		return "Process " + p.getName() + " " + p.getId() + " " + " priority set to " + p.getPriority();
	}
}
