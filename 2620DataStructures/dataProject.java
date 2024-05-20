//Import scanner for switch case
import java.util.Scanner;

public class dataProject {
    /**
	 * @param args Main class file for the entire program 2620DataStructures
	 * Main menu switch case interface
	 * Prompts user to input a number according to the data structure they want to work with
	 */
	public static void main(String[] args) {
		while (true) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select the data structure you want to work with.\nEnter 1 for Linked List\nEnter 2 for Stack\nEnter 3 for Queue\nEnter 4 for Min Heap\nEnter 5 for Binary Search Tree (BST)\nEnter 6 to exit program");
		int mainoption = scan.nextInt();

		switch (mainoption) {
			//LinkedList option
			case 1:
			//Declare LinkedList array, inputs and display options
			LinkedListOption list = new LinkedListOption();
			System.out.println("You have selected LinkedList.");
			try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
			  list.handleLinkedListOperations(scan);
			  break;

			//Stack option
			case 2:
			//Declare stack list array, inputs and display options
			StackOption slist = new StackOption(10);
			System.out.println("You have selected Stack.\nThis operation is done using LIFO (Last-in, First-out).\nYour array has 10 spots.");
			try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
			slist.handleStackOperations(scan);
			break;

			//Queue option
			case 3:
			//Declare queue LinkedList, input and display options
			QueueOption queue = new QueueOption();
			System.out.println("You have selected Queue.\nThis operation is done using FIFO (First-in, First-out.)\nLinkedList will be used.");
			try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
			queue.handleQueueOperations(scan);
			break;

			//Minheap option
			case 4:
			//Declare MinHeap BST, inputs and display options
			MinHeapOption mhBST = new MinHeapOption();
			System.out.println("You have selected MinHeap. This operation is done utilizing the Binary Tree stucture.");
			try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
			mhBST.handleMinHeapOperations(scan);
			break;

			//BST option
			case 5:
			//Declare binary search tree, inputs and display options
			BSTOption tree = new BSTOption();
			System.out.println("You have selected Binary Search Tree.");
			try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
			tree.handleBSTOperations(scan);
			break;

			//Exit Option
			case 6:
			System.out.println("You have exited the program.");
			System.exit(0);

			//Reject imputs other than menu and prompt user to input a recognized option
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
