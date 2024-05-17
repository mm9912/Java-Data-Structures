//Import scanner for switch case
import java.util.Scanner;

public class LinkedListOption {
    //Declare node head
    Node head;

    //Declare structure
    static class Node {
        public int data;
        public Node next;
        public Node (int d) {
            data = d;
            next = null;
        }
    }

    //Method to insert data into LinkedList
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //Method to delete a node from LinkedList
    public void deleteNodeByKey(int key) {
        Node current = head;
        Node prev = null;
        // If the head node itself holds the key to be deleted
        if (current != null && current.data == key) {
            // Update the head to skip the first node
            head = current.next;
            System.out.println("The value has successfully been deleted! Input option 3 to view new Linked List.");
            return;
        }
        // Search for the node with the key to be deleted
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        // If the key was not found in the list
        if (current == null) {
            System.out.println("The value you searched for is not on the Linked List.");
            return;
        }
        // Unlink the node with the key to be deleted
        System.out.println("The value has successfully been deleted! Input option 3 to view new Linked List.");
        prev.next = current.next;
    }

    //Method to display the LinkedList
    public void traverse () {
Node current = head;
while (current != null) {
    System.out.println("V\n" + current.data);
    current = current.next;
}
System.out.println();
}

//Class that handles LinkedLists data structures.
public void handleLinkedListOperations(Scanner scan) {
    while (true) {
        System.out.println("What do you want to do with the linked list?");
        System.out.println("1. Add Data\n2. Remove Data\n3. Display LinkedList\n4. Exit to Main Menu");
        int option = scan.nextInt();

        switch (option) {
            //Case that creates a new LinkedList.
            //User is prompted to enter values of their liking until they input -1 to finish their LinkedList.
            case 1:
                System.out.println("Enter the data to add to the Linked List. Input -1 to finish inputting data.");
                int input = 0;
                while (input != -1) {
                    input = scan.nextInt();
                    if (input != -1) {
                        insert(input);
                    }
                }
                break;

            //Case that deletes a specific value from LinkedList.
            //User is prompted to enter a value they'd like to be removed from the LinkedList.
            case 2:
                System.out.println("Enter the value/key you'd like to delete.");
                int inputD = scan.nextInt();
                deleteNodeByKey(inputD);
                try {
                    Thread.sleep(1000);
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                break;

            //Case that displays the user's LinkedList.
            //Displays current LinkList created by user based on recent edits from other case functions.
            case 3:
            System.out.println("LinkedList: ");
                traverse();
                break;

            //Case that brings user back to main menu.
            //Displays a message informing user that they will be returned to the main menu.
            case 4:
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
