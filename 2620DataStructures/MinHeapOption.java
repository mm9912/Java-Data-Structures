//Import scanner for switch case
import java.util.Scanner;

class Node {
    //Binary tree implementation
    int value;
    Node left;
    Node right;

    //Keep track of int values and child references
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class MinHeapOption {
    //Declare node of the tree
    Node root;

    //Method to insert elements into tree.
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
    
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
    
        return current;
    }

    //Method to call in order to add values (elements).
    public void minHeapadd(int value) {
        root = addRecursive(root, value);
    }

    //ExtractMin method
    public int extractMin() {
        if (root == null) {
            System.out.println("Heap is empty. Returning -1 due to empty heap. Please insert elements first.");
            try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            return -1;
        }
        int minValue = findMinValue(root);
        root = deleteRecursive(root, minValue);
        return minValue;
    }

    private int findMinValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    //Method to deletes elements from the tree
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            if (current.left == null && current.right == null) {
                // Case 1: Node has no children
                return null;
            } else if (current.right == null) {
                // Case 2: Node has one child (left child)
                return current.left;
            } else if (current.left == null) {
                // Case 2: Node has one child (right child)
                return current.right;
            } else {
                // Case 3: Node has two children
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    //Class that handles Queue BST data structures.
		public void handleMinHeapOperations(Scanner scan) {
			while (true) {
				System.out.println("What do you want to do with the Min Heap?");
				System.out.println("1. Insert\n2. ExtractMin\n3. Exit");
				int option = scan.nextInt();
	
				switch (option) {
					//Case where a user can insert values into the queue.
					//User is prompted to enter values into queue until -1 is entered.
					case 1:
					System.out.println("Enter a number to insert into the BST. Input -1 to finish inputting data.");
						int input = 0;
						while (input != -1) {
							input = scan.nextInt();
							if (input != -1) {
								minHeapadd(input);
							}
						}
						break;

					//Casse where a user selects extracts the minHeap from the heap list.
					//When option is selected, the lowest value in the binary tree is removed.
					case 2:
					System.out.println("Min element extracted: " + extractMin());
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
