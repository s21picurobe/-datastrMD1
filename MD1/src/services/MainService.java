package services;

import java.io.*;
import java.util.*;

import models.MyStack;
import models.Student;
import models.Bracket;
import models.MyQueue;
import models.MyDeque;

public class MainService {

	//could have easily used a single Node class for all :(
	public static void main(String[] args) throws Exception{
			System.out.println("Have to rerun for each task, as I did not manage to figure out how to clear eclipse terminal");
			System.out.println("Stack<1> Queue<2> Deque<3> CallCenter<4> BrowserHistory<5>");
			System.out.print("enter:");
			
			Scanner userInput = new Scanner(System.in);
			char input = userInput.next().charAt(0); 
			
			//STACK
			if (input == '1') {
				userInput.close();
				
				MyStack stackInt = new MyStack();
				MyStack stackStdnt = new MyStack();
				
				System.out.println("\u001b[30;1m" + "STACK" + "\u001b[0m");
				
				System.out.println("Fill with push():");
				for (int i = 0; i < 5; i++) {
					stackInt.push(i);
					stackStdnt.push(new Student());
					stackInt.print();
					stackStdnt.print();
					System.out.println("");
				}
				
				System.out.println("Empty with pop():");
				for (int i = 0; i < 5; i++) {
					stackInt.pop();
					stackStdnt.pop();
					stackInt.print();
					stackStdnt.print();
					System.out.println("");
				}
				
				System.out.println("Empty with clear():");
				for (int i = 0; i < 5; i++) {
					stackInt.push(i);
					stackStdnt.push(new Student());
				}
				stackInt.clear();
				stackStdnt.clear();
				System.out.println("");
				stackInt.print();
				stackStdnt.print();
				System.out.println("");
				
				System.out.println("[startY, startX, endY, endX] " + Arrays.toString(syntaxTestBrackets("resources/Student.java")));
				System.out.println("");
				System.out.println("[startY, startX, endY, endX] " + Arrays.toString(syntaxTestBrackets("resources/UserController.java")));
				System.out.println("");
				System.out.println("[startY, startX, endY, endX] " + Arrays.toString(syntaxTestBrackets("resources/UserServiceImplTest.java")));
				System.out.println("");
			}
			
			//QUEUE
			if (input == '2') {
				userInput.close();
				System.out.println("\u001b[30;1m" + "QUEUE" + "\u001b[0m");
				MyQueue queueInt = new MyQueue();
				MyQueue queueStdnt = new MyQueue();
				
				System.out.println("Fill with enqueue():");
				for (int i = 0; i < 5; i++) {
					queueInt.enqueue(i);
					queueStdnt.enqueue(new Student());
					queueInt.print();
					queueStdnt.print();
					System.out.println("");
				}
				
				System.out.println("Empty with dequeue():");
				for (int i = 0; i < 5; i++) {
					queueInt.dequeue();
					queueStdnt.dequeue();
					queueInt.print();
					queueStdnt.print();
					System.out.println("");
				}
				
				System.out.println("Empty with clear():");
				for (int i = 0; i < 5; i++) {
					queueInt.enqueue(i);
					queueStdnt.enqueue(new Student());
				}
				queueInt.clear();
				queueStdnt.clear();
				queueInt.print();
				queueStdnt.print();
				
			}
			if (input == '4') {
				userInput.close();
				MyQueue queue = new MyQueue();
				callCenter(queue);
			}
			
			if (input == '3') {
				MyDeque deque = new MyDeque();
				System.out.println("Fill with pushFront():");
				for (int i = 0; i < 4; i++) {
					deque.pushFront(i);
					deque.print();
				}
				System.out.println("Empty with popFront():");
				for (int i = 0; i < 4; i++) {
					deque.popFront();
					deque.print();
				}
				System.out.println("Fill with pushRear():");
				for (int i = 0; i < 4; i++) {
					deque.pushRear(i);
					deque.print();
				}
				System.out.println("Empty with popRear():");
				for (int i = 0; i < 4; i++) {
					deque.popRear();
					deque.print();
				}
				MyDeque dequeStdnt = new MyDeque();
				System.out.println("Fill with pushFront():");
				for (int i = 0; i < 4; i++) {
					dequeStdnt.pushFront(new Student());
					dequeStdnt.print();
				}
				System.out.println("Empty with popFront():");
				for (int i = 0; i < 4; i++) {
					dequeStdnt.popFront();
					dequeStdnt.print();
				}
				System.out.println("Fill with pushRear():");
				for (int i = 0; i < 4; i++) {
					dequeStdnt.pushRear(new Student());
					dequeStdnt.print();
				}
				System.out.println("Empty with popRear():");
				for (int i = 0; i < 4; i++) {
					dequeStdnt.popRear();
					dequeStdnt.print();
				}
			}
			if (input == '5') {
				System.out.println("To save time only 3 records deep history and url format is xxx.xxx.xxx - without https...");
				urlHistory();
			}
 	}
	
	public static void urlHistory() throws Exception {
		MyDeque urls = new MyDeque();
		Scanner scanner = new Scanner(System.in);
		String input;
		int length = 0;
		final int MAX_LENGTH = 3;
		
		while(true) {
			urls.print();
			System.out.print("Enter URL(popFront()<1> exit<0>: ");
			
			input = scanner.nextLine();
			input = input.substring(0, input.length());
			
			if(input.equals("1")) {
				if(length > 0) {
					try {
						System.out.println(urls.getFrontNode().getElement());
						urls.popFront();
						length--;
					}
					catch (Exception e) {
						System.out.println(e);
					}
				}
				else {
					System.out.println("No history");
				}
			} else if (input.equals("0")) {
				break;	
			} else if(input.matches("^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
				urls.pushFront(input);
				length++;
				if(length > MAX_LENGTH) {
					try {
						urls.popRear();
						length--;
					}
					catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		}
	}
	
	public static String generateNumber() {
		int twoOrSix = new Random().nextInt(0,10) % 2;
		String output = "" + (2*(twoOrSix * 2)+2);
		for (int i = 0; i < 7; i++) {
			output += new Random().nextInt(0, 10);
		}
		return output;
	}
	
	public static void callCenter(MyQueue queue) throws InterruptedException {
		Thread call = new Thread() {
		    public void run() {
		    	while (true) {
			    	try {
			    		Thread.sleep(new Random().nextInt(0,10) * 500);
						queue.enqueue(generateNumber());
						System.out.println("\u001b[32;1m" + queue + "\u001b[0m");
					} catch (Exception e) {
					}
		    	}
		    }
		};
		
		Thread answer = new Thread() {
		    public void run() {
		    	while (true) {
			    	try {
			    		Thread.sleep(new Random().nextInt(0,10) * 500);
						queue.dequeue();
						System.out.println("\u001b[31;1m" + queue + "\u001b[0m");
					} catch (Exception e) {
					}
		    	}
		    }
		};

		call.start();
		answer.start();	
	}
	
	public static int[] syntaxTestBrackets(String path) throws Exception{
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		MyStack stack = new MyStack();
		char[] line;
		int yIndex = 0;
		int xIndex = 0;
		boolean openSingle = false;
		boolean openDouble = false;
		
		while (scanner.hasNextLine()) {
			char prevChar = ' ';
			yIndex++;
			line = scanner.nextLine().toCharArray();
			for (int i = 1; i < line.length; i++) {
				if (line[i] == '\'' && !openDouble && prevChar != '\\') {
					openSingle = !openSingle;
				}
				if (line[i] == '"' && !openSingle) {
					openDouble = !openDouble;
				}
				xIndex = i;
				if (!openDouble && !openSingle) {
					if (line[i] == '(' || line[i] == '{' || line[i] == '[') {
						stack.push(new Bracket(line[i], yIndex, xIndex));
					}
					if (line[i] == ')' || line[i] == '}' || line[i] == ']') {
						int sum = (int)line[i] + ((Bracket)stack.top().getElement()).bracket; //first cast to char as MyStackNode class is a template
						if (sum == 81 || sum == 184 || sum == 248) {
							stack.pop();
						}
						else {
							Scanner visualizerScanner = new Scanner(file);
							System.out.println("Bracket errors in " + path);
							for (int j = 1; j < ((Bracket)stack.top().getElement()).y; j++) {
								visualizerScanner.nextLine();
							}
							for (int k = ((Bracket)stack.top().getElement()).y; k <= yIndex; k++) {
									System.out.println("\u001b[31m" + k + visualizerScanner.nextLine() + "\u001b[0m");
							}
							return new int[]{((Bracket)stack.top().getElement()).y,((Bracket)stack.top().getElement()).x,yIndex,xIndex};
						}
					}
				}
				prevChar = line[i];
			}
		}
		return new int[]{0,0,0,0};
	}
}
