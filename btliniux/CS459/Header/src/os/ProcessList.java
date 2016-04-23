package os;

import java.io.Serializable;

public class ProcessList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Process head;
	private Process tail;
	public ProcessList prev;
	public ProcessList next;
	

	public ProcessList(String name){
		head = null;
		tail = null;
		prev = null;
		next = null;
		this.name =  name;
		
		}
	
	public Process setPriority(long id, int priority){
		Process change = find(id);
		change.setPriority(priority);
		return change;
	}

	public String toString(){
		String strin = "";
		Process curr = head;
		while(curr.next!=null){
			strin += curr.getName() + " ";
		}
		return strin;
	}
	
	public boolean isEmpty(){
		return (head==null);
	}
	
	public Process peek(){
		return head;
	}
	
	public void enQueue(Process p){
		if(isEmpty()){
			head = p;
		} else {
			Process current = head;
			while(current.next != null){
				current = current.next;
			}
			tail = p;
			tail.previous = current;
			current.next = p;
		}
	}
	
	public Process deQueue(){
		Process cut = head;
		if(cut.next == null){
			head = null;
			tail = null;
		} else {
			head = cut.next;
			head.previous = null;
		}
		return cut;	
	}
	
	public Process remove(long id){
		Process cut;
		cut = find(id);
		if(cut == null){ 
		} else if (cut == head) {
			cut = deQueue();
		} else if(cut == tail){
			tail = cut.previous; 
			tail.next = null; 
		} else {
			cut.previous.next = cut.next;
			cut.next.previous = cut.previous;
		}
		return cut;
	}
	
	public Process find(long id){
		Process curr = head;
		
		while(curr != null){
			if(curr.getId() == id)return curr;
			curr = curr.next;
			
		}
		 return null;
	}
	
	public String getName(){
		return name;
	}
}