package models;

public class MyStack<T> {
	//variables
	private MyStackNode topNode;
	private MyStackNode botNode;
	private int length;
	
	//constructors
	public MyStack() {
		topNode = null;
		botNode = null;
		length = 0;
	}
	
	//functions
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int getLength() {
		return length;
	}
	
	public void push(T element) throws Exception {
		try {
			MyStackNode newNode = new MyStackNode(element);
			if (isEmpty()) {
				botNode = newNode;
			} else if (length == 1) {
				newNode.setPrevNode(botNode);
				botNode.setNextNode(newNode);
			} else {
				newNode.setPrevNode(topNode);
				topNode.setNextNode(newNode);
			}
			topNode = newNode;
			length++;
		} catch(OutOfMemoryError e) {
			throw new Exception("Stack full");
		}
	}
	
	public void pop() throws Exception{
			if (!isEmpty()) {
				if (length == 1) {
					topNode = null;
					botNode = null;
				} else {
					topNode = topNode.getPrevNode();
					topNode.setNextNode(null);
				}
				length--;
			} else {
				throw new Exception("Stack empty");
			}
	}
	
	public MyStackNode top() throws Exception {
		if (length != 0) {
			return topNode;
		} else {
			throw new Exception("Stack empty");
		}
	}
	
	
	public void clear() {
		topNode = null;
		botNode = null;
		length = 0;
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public String toString()  { //implemented nextNode and botNode to print the stack in the same order as built-in
		String output = "[";
		if (!isEmpty()) {
			MyStackNode tempNode = botNode;
			for (int i = 1; i < length; i++) {
				output += tempNode + ", ";
				tempNode = tempNode.getNextNode();
			}
			output+= tempNode;
		}
		return output + "]";
	}
	
	
}
