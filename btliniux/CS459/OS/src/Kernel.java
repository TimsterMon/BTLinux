// Ben Boyd & Tim Werner OS- BTliniux

import java.io.PrintWriter;

import console.CommandListener;
import console.OSConsole;
import os.BatchList;
import os.CliCommand;
import os.ProcessList;
import os.Program;

public class Kernel implements CommandListener{
	OSConsole console;
	@SuppressWarnings("rawtypes")
	Class className;
	Program classInstance;
	CliCommand com;
	ProcessList list;
	BatchList batch;
	PrintWriter out;
	String args[];
	String name;

	public static void main(String[] args) {
		new Kernel();
	}
	
	public Kernel(){
		console = new OSConsole("BTLinux : Batch Sequencer");
		console.setCommandListener(this);
		batch = new BatchList();
		console.write("Prompt--->  ");
		//console.login();
	}
	
	@Override
	public void commandReceived(String input){
		// copy input into command
		String command = input;
		String[] argData = command.split(" ");
		// either set up the program or assume OS command
		command = argData[0].substring(0, 1).toUpperCase() + argData[0].substring(1).toLowerCase();
		// try/catch
	       try{  
	           className = Class.forName("cli." + command);  // Call the class loader to load and compile the command
	           com = (CliCommand) className.newInstance();
	           
	           if(argData.length > 1){ 
		   			args = new String[argData.length - 1];
		   			System.arraycopy(argData, 1, args, 0, args.length);
		   			args[0] = args[0].substring(0, 1).toUpperCase() + args[0].substring(1).toLowerCase();
		   		    name = args[0] + " initialized";
	   			}
	         
	            String call = com.execute(args, list, batch); //find command
	   			
	   			if(call.equals(name)){
	   				list = new ProcessList(args[0]);  // new batch created
	   				batch.enQueue(list); //add batch to list
	   				console.writeLine(call);
	   			}
	   			else if(argData.length > 1 && call.equals(args[0])){
	   				list = batch.find(call); // change the active batch
	   				console.writeLine(call + " is now active");
	   			}
	   			else console.writeLine(call);
	   			args = null; // clear the args, otherwise run command collects old args
	   			
	       } catch (Throwable t){ 
	    	   if(list == null) console.writeLine("No batch has been initalized" ); //no batch exists
	    	   else console.writeLine("Command not found" );// The class file did not exist
	       } //end try/catch
	       console.write("Prompt--->  ");
	 }  // End CommandReceived method
}// end Kernel