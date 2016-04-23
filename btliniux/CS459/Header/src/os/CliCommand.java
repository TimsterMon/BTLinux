package os;
public abstract class CliCommand {
	
	public abstract String execute(String[] args, ProcessList list, BatchList batch) throws InterruptedException;
}
