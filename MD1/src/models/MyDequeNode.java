package models;

public class MyDequeNode<T> {
	//variables
	private T element;
	private MyDequeNode nextNode;
	private MyDequeNode prevNode;
		
	//constructors
	public MyDequeNode(T element) {
		prevNode = null;
		nextNode = null;
		setElement(element);
	}
	
	//setters
	public void setElement(T element) {
		if (element != null) {
			this.element = element;
		} else {
			this.element = (T) new Object();
		}
	}
	
	public void setNextNode(MyDequeNode node) {
		nextNode = node;
	}
	
	public void setPrevNode(MyDequeNode node) {
		prevNode = node;
	}
	
	//getters 
	public T getElement() {
		return element;
	}
	
	public MyDequeNode getNextNode() {
		return nextNode;
	}
	
	public MyDequeNode getPrevNode() {
		return prevNode;
	}
	
	//toString
	public String toString() {
		return "" + element;
	}
}
