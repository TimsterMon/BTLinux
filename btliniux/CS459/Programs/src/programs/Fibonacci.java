package programs;
import java.io.*;
import os.*;

public class Fibonacci extends Program implements Serializable {
	// harvey's Fibonacci programme
	private static final long serialVersionUID = 1L;
	public Fibonacci(){
		super("Fibonacci Calculator");
	}
	//
	public int run(PrintWriter out, String[] args)throws InterruptedException{
		
		try{
			long maxNumber = Long.parseLong(args[1]);
			if(maxNumber<1)
				return(ILLEGAL_PARAMETER);
			out.println(args[0]+ ": Sequence up to " + maxNumber + " numbers");
			if(maxNumber>=1)
				out.println(1);
			if(maxNumber>=2)
				out.println(1);
			long first = 1, second = 1, newNumber;
			for(int i=2;i<maxNumber;i++){
				newNumber = first + second;
				first = second;
				second = newNumber;
				out.println(newNumber);
			}
		} catch(Exception e){
			return ILLEGAL_PARAMETER;
		}
		return SUCCESS;
	}
}

