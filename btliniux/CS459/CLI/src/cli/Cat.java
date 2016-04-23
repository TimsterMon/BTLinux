// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import os.ProcessList;
import os.BatchList;
import os.CliCommand;

public class Cat extends CliCommand {
	//execute method
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {

		  String line;
		  BufferedReader br = null;
		  StringBuilder builder = new StringBuilder();
			      try{		        
			    	 File file = new File(args[0]);
					 BufferedReader reader = new BufferedReader(new FileReader(file));
					 br  = new BufferedReader(reader);
			         while ((line = br.readLine()) != null) {
			           builder.append(line);
			           builder.append("\n");
			         }       
			           br.close();
			      }catch(Throwable t){
			       return "File not found";
			      }
		return builder.toString();
	}
	
}