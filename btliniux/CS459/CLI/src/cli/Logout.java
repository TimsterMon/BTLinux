// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import os.BatchList;
import os.CliCommand;
import os.ProcessList;

public class Logout extends CliCommand {
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		System.exit(0);
		
		return null;
	}
}
