// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.Process;
import os.ProcessList;
import os.Program;

public class List extends CliCommand{
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		String batches = batch.traverse();
		
		return batches;
	}
}