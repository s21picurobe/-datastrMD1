package models;

public class MyQueue<T> {
	//variables
	private MyQueueNode rearNode;
	private MyQueueNode frontNode;
	volatile private int length;
	
	//constructors
	public MyQueue() {
		rearNode = null;
		frontNode = null;
		length = 0;
	}
	
	//functions
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		}
		return false;
	}
	
	public int getLength() {
		return length;
	}
	
	public void enqueue(T element) throws Exception {
		try {
			MyQueueNode newNode = new MyQueueNode(element);
			if (isEmpty()) {
				frontNode = newNode;
			} else if (length == 1) {
				frontNode.setNextNode(newNode);
				newNode.setPrevNode(frontNode);
			} else {
				rearNode.setNextNode(newNode);
				newNode.setPrevNode(rearNode);
			}
			rearNode = newNode;
			length++;
		} catch(OutOfMemoryError e) {
			throw new Exception("Stack full");
		}
	}
	
	public void dequeue() throws Exception {
		if (!isEmpty()) {
			if (length == 1) {
				frontNode = null;
				rearNode = null;
			} else {
				frontNode = frontNode.getNextNode();
				frontNode.setPrevNode(null);
			}
			length--;
		} else {
			throw new Exception("Queue empty");
		}
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public void clear() {
		frontNode = null;
		rearNode = null;
		length = 0;
	}
	
	//toString
	public String toString() {
		String output = "[";
		if (!isEmpty()) {
			MyQueueNode tempNode = frontNode; 
			for (int i = 0; i < length-1; i++) {
				output += tempNode + ", ";
				tempNode = tempNode.getNextNode();
			}
			output += tempNode;
		}
		return output + "]";
	}
}
