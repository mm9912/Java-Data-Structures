//Import scanner for switch case.
import java.util.Scanner;

class Node {
    //Binary tree implementation.
    int value;
    Node left;
    Node right;

    //Keep track of int values and child references.
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class BSTOption {
    //Declare node of the tree.
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
            //Value already exists.
            return current;
        }
    
        return current;
    }

    //Method to call in order to add values (elements).
    public void add(int value) {
        root = addRecursive(root, value);
    }

    //Method to deletes elements from the tree.
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            //Node to delete found.
            if (current.left == null && current.right == null) {
                //Case 1: Node has no children.
                return null;
            } else if (current.right == null) {
                //Case 2: Node has one child (left child).
                return current.left;
            } else if (current.left == null) {
                //Case 2: Node has one child (right child).
                return current.right;
            } else {
                //Case 3: Node has two children.
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

    //Method to find smallest value in tree.
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    //Public method to call private method of deleting values.
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    //Method to search for value inside of the tree.
    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        } 
        if (value == current.value) {
            return true;
        } 
        return value < current.value
          ? containsNodeRecursive(current.left, value)
          : containsNodeRecursive(current.right, value);
    }

    //Public method to call the private method of tree searching.
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    //Method to display binary search tree.
public void traverseInOrder(Node node) {
    if (node != null) {
        traverseInOrder(node.left);
        System.out.print(" -> " + node.value);
        traverseInOrder(node.right);
    }
}

    //Method that handles user requests for Binary Search Tree data structures.
    //Menu called from main class to let user interact with data structure.
		public void handleBSTOperations(Scanner scan) {
			while (true) {
				System.out.println("What do you want to do with the Binary Search Tree (BST)?");
				System.out.println("1. Insert Node\n2. Delete Node\n3. Find Node\n4. Inorder Traversal\n5. Exit");
				int option = scan.nextInt();
	
				switch (option) {
					//Case where user insert's keys (numbers) into the tree.
					//Prompts user to enter values into the tree until they insert -1.
					case 1:
					System.out.println("Enter a number to insert into the BST. Input -1 to finish inputting data.");
						int input = 0;
						while (input != -1) {
							input = scan.nextInt();
							if (input != -1) {
								add(input);
							}
						}
					break;

					//Case where user deletes keys (numbers) from the tree.
					//Prompts user to delete values from tree until they insert -1.
					case 2:
					System.out.println("Enter a number you'd like to delete from the BST. Input -1 to finish deleting data.");
					int inputDelete = 0;
					while (inputDelete != -1) {
						inputDelete = scan.nextInt();
						if (inputDelete != -1) {
							delete(inputDelete);
						}
					}
					break;

					//Case where use validates if a number is in a binary tree.
					//Prompts user to input number and BSTOption searches for it using containsNode.
					case 3:
					System.out.println("Enter the value you would like to find in the tree.");
					int valueSearch = 0;
					valueSearch = scan.nextInt();
					System.out.println("You searched for: " + valueSearch + ". Status: " + containsNode(valueSearch));
					break;

					//Case where the binary tree is printed in inorder traversal.
					//Takes in all user inputs and prints in inorder traversal.
					case 4:
					traverseInOrder(root);
					System.out.println("\n");
					break;

					//Case that brings user back to main menu.
					//Displays a message informing user that they will be returned to the main menu.
					case 5:
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
}
