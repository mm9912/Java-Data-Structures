//Import scanner for switch case
import java.util.Scanner;

public class QueueOption {
    private Node front, back;

    public QueueOption () {
        front = null;
        back = null;
    }

    //Method to add items into the queue
    public void enqueue(Object item) {
        Node newNode = new Node(item);
        if (front == null) {
            front = newNode;
        }
        if (back != null) {
            back.next = newNode;
        }
        back = newNode;
    }

    //Method to remove items from the queue
    public Object dequeue () {
        Object toReturn = null; 
        if (front != null) {
            toReturn = front.item;
            front = front.next;
        }
        if (front == null) {
            back = null;
        }
        return toReturn;
    }

    //Method in case where queue is empty
    public boolean empty () {
        return front == null;
    }

    //Declare linked list structure
    private class Node {
        Object item;
        Node next;

        public Node (Object item) {
            this.item = item;
            this.next = null;
        }
    }

    //Class that handles Queue BST data structures.
		public void handleQueueOperations(Scanner scan) {
			while (true) {
				System.out.println("What do you want to do with the Queue?");
				System.out.println("1. Enqueue\n2. Dequeue\n3. Exit");
				int option = scan.nextInt();
	
				switch (option) {
					//Case where a user can insert values into the queue.
					//User is prompted to enter values into queue until -1 is entered.
					case 1:
					System.out.println("Enter a number to insert into the Queue. Input -1 to finish inputting data.");
						int input = 0;
						while (input != -1) {
							input = scan.nextInt();
							if (input != -1) {
								enqueue(input);
							}
						}
						break;

					//Case where a user deletes an element from the queue.
					//When option is selected, the first element is deleted.
					case 2:
					System.out.println("Dequeued Eelement: " + dequeue());
					break;

					//Case that brings user back to main menu.
					//Displays a message informing user that they will be returned to the main menu.
					case 3:
					System.out.println("Returning to main menu.");
					try {
						Thread.sleep(1000);
					  } catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					  }
					return;

				//Special case where the user does not input a recognized value.
				//The user is prompted to input a valid option.
				default:
					System.out.println("Invalid input. Please try again.");
					try {
						Thread.sleep(1000);
					  } catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					  }
				}
			}
		}
}
