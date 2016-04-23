// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import os.BatchList;
import os.CliCommand;
import os.Process;
import os.ProcessList;
import os.Program;

public class Save extends CliCommand{
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		
		try {
            System.out.println("serializing list");
            FileOutputStream fout = new FileOutputStream(args[0] + ".sav");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            if(batch.find(list.getName()) != null) {oos.close(); return "Batch already exists";} 

            oos.writeObject(list);
            oos.close();
        }
        catch (Exception e) { 
            return "Batch failed to be saved";
        }
		
		
		return "Batch " + list.getName() + " saved";
	}
}