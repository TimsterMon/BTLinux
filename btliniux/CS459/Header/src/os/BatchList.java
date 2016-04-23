package os;

public class BatchList {
	private ProcessList head;
	private ProcessList tail;

	
	public BatchList(){
		head = null;
		tail = null;
	}
	
	public boolean isEmpty(){
		return (head==null);
	}
	
	public ProcessList peek(){
		return head;
	}
	
	public void enQueue(ProcessList p){
		if(isEmpty()){
			head = p;
		} else {
			ProcessList current = head;
			while(current.next != null){
				current = current.next;
			}
			tail = p;
			tail.prev = current;
			current.next = p;
		}
	}
	
	public ProcessList deQueue(){
		ProcessList cut = head;
		if(cut.next == null){
			head = null;
			tail = null;
		} else {
			head = cut.next;
			head.prev = null;
		}
		return cut;	
	}
	
	public ProcessList remove(String id){
		ProcessList cut;
		cut = find(id);
		if(cut == null){ return null; 
		} else if (cut == head) {
			cut = deQueue();
		} else if(cut == tail){
			tail = cut.prev; 
			tail.next = null; 
		} else {
			cut.prev.next = cut.next;
			cut.next.prev = cut.prev;
		}
		return cut;
	}
	
	public ProcessList find(String id){
		ProcessList curr = head;
		
		while(curr != null){
			if(curr.getName().equals(id))return curr;
			curr = curr.next;
		}
		 return null;
	}
	
	public String traverse(){
		ProcessList curr = head;
		StringBuilder builder = new StringBuilder();
		while(curr != null){
			builder.append(curr.getName());
			builder.append("\n");
			curr = curr.next;
		}
		 return builder.toString();	
	}
	
}
