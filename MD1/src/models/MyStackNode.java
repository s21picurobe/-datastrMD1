package models;

public class MyStackNode<T> {
	//variables
	private T element;
	private MyStackNode prevNode;
	private MyStackNode nextNode;
	
	//constructors
	public MyStackNode(T element) {
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
	
	public void setPrevNode(MyStackNode node) {
		prevNode = node;
	}
	
	public void setNextNode(MyStackNode node) {
		nextNode = node;
	}
	
	//getters
	public T getElement() {
		return element;
	}
	
	public MyStackNode getPrevNode() {
		return prevNode;
	}
	
	public MyStackNode getNextNode() {
		return nextNode;
	}
	
	public String toString() {
		return "" + element;
	}
}
