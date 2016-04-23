package os;

import java.io.*;

public abstract class Program implements Serializable{
	//
	public final static long serialVersionUID = 1;
		// class variables
		public final static int SUCCESS = 0;
		public final static int ILLEGAL_PARAMETER = 1;
		private String name;
		// constructor
		public Program(String name){
			this.name = name;
		}
		// return process name
		public String getName(){
			return name;
		}
		// abstract run method
		public abstract int run(PrintWriter out, String[] args) throws InterruptedException;
		// fair share scheduling and check time limit interrupts
		public void schedule() throws InterruptedException{
			throw new InterruptedException("This method will be completed in a later lab");
		}
		// os system call interface
		public String system(){
			return "This method will be completed in a later lab";
		}
		// method for orderly shutdown (overridden in application in a later lab)
		public void terminate(){};
}
