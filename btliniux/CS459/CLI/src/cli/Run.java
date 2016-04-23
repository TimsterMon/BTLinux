// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import os.BatchList;
import os.CliCommand;
import os.ProcessList;
import os.Program;

public class Run extends CliCommand  {
	PrintWriter out;
	@SuppressWarnings("rawtypes")
	Class className;
	Program classInstance;
	//execute method
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		os.Process p = list.peek();
		File file = new File(args[0] + ".bat"); 
		String ran = null;
		StringBuilder builder = new StringBuilder();
		try {
			out = new PrintWriter(file);
			out.close();
		} catch (FileNotFoundException e) {
			return "error occured";
		}
		while(p != null){
			  try{     
					ran = p.run(out, file);
					builder.append(ran);
					list.deQueue();
		       } catch (Throwable t){ 
		    	   return "Program error";
		       }
			  p = p.next;
		}
		return builder.toString();
	}
}
