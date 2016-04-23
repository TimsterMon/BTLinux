// Ben Boyd & Tim Werner OS- BTliniux

package cli;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import os.BatchList;
import os.CliCommand;
import os.ProcessList;
import os.Program;

public class Load extends CliCommand{
	Program classInstance;
	@Override
	public String execute(String[] args, ProcessList list, BatchList batch) {
		

        try {
            FileInputStream fin = new FileInputStream(args[0] + ".sav");
            ObjectInputStream ois = new ObjectInputStream(fin);
            list =  (ProcessList) ois.readObject();
            if(batch.find(list.getName()) != null) {ois.close(); return "Batch already exists";} 
            batch.enQueue(list);
            ois.close();
        }
        catch (Exception e) { 
            return "Batch not found";
        }
		
		return list.getName();
	}
}