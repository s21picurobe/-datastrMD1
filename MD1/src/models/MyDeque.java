package models;
import models.MyDequeNode;

public class MyDeque<T> {
	//variables
		private MyDequeNode rearNode;
		private MyDequeNode frontNode;
		volatile private int length;
		
		//constructors
		public MyDeque() {
			rearNode = null;
			frontNode = null;
			length = 0;
		}
		//getters
		public MyDequeNode getFrontNode() {
			return frontNode;
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
		
		public void pushRear(T element) throws Exception {
			try {
				MyDequeNode newNode = new MyDequeNode(element);
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
		
		public void pushFront(T element) throws Exception {
			try {
				MyDequeNode newNode = new MyDequeNode(element);
				if (isEmpty()) {
					rearNode = newNode;
				} else if (length == 1) {
					rearNode.setPrevNode(newNode);
					newNode.setNextNode(rearNode);
				} else {
					frontNode.setPrevNode(newNode);
					newNode.setNextNode(frontNode);
				}
				frontNode = newNode;
				length++;
			} catch(OutOfMemoryError e) {
				throw new Exception("Stack full");
			}
		}
		
		public void popRear() throws Exception {
			if (!isEmpty()) {
				if (length == 1) {
					frontNode = null;
					rearNode = null;
				} else {
					rearNode = rearNode.getPrevNode();
					rearNode.setNextNode(null);
				}
				length--;
			} else {
				throw new Exception("Queue empty");
			}
		}
		
		public void popFront() throws Exception {
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
				MyDequeNode tempNode = frontNode; 
				for (int i = 0; i < length-1; i++) {
					output += tempNode + ", ";
					tempNode = tempNode.getNextNode();
				}
				output += tempNode;
			}
			return output + "]";
		}
}
