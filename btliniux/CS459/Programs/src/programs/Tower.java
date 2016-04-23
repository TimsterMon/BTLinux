package programs;
import java.io.PrintWriter;
import java.io.Serializable;

import os.Program;

public class Tower  extends Program implements Serializable{
	//
	private static final long serialVersionUID = 1L;
	public Tower(){
		super("Towers of Hanoi");
	}
	public int run(PrintWriter out, String[] args)throws InterruptedException{
		try{
	        int discs = Integer.parseInt(args[1]);
	        out.println("Tower: " + discs + " rings");
		    solve(out, discs, "1", "2", "3");
        } catch(Exception e){
        	return ILLEGAL_PARAMETER;
        }
              return SUCCESS;
     } 
     public void solve(PrintWriter out, int n, String start, String auxiliary, String end){
	       if (n == 1){
	           out.println("Moves from " + start + " to " + end);
	       } else {
	           solve(out,n - 1, start, end, auxiliary);
	           out.println("Moves from " + start + " to " + end);
	           solve(out, n - 1, auxiliary, start, end);
	       }
      }
}