package models;

public class MyQueueNode<T> {
	//variables
	private T element;
	private MyQueueNode prevNode;
	private MyQueueNode nextNode;
	
	//constructors
	public MyQueueNode(T element) {
		prevNode = null;
		nextNode = null;
		setElement(element);
	}
	
	//setters
	private void setElement(T element) {
		if (element != null) {
			this.element = element;
		} else {
			element = (T) new Object();
		}
	}
	
	public void setPrevNode(MyQueueNode node) {
		prevNode = node;
	}
	
	public void setNextNode(MyQueueNode node) {
		nextNode = node;
	}
	
	//getters
	public T getElement() {
		return element;
	}
	
	public MyQueueNode getPrevNode() {
		return prevNode;
	}
	
	public MyQueueNode getNextNode() {
		return nextNode;
	}
	
	//toString
	public String toString() {
		return "" + element;
	}
}