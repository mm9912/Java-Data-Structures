//Import scanner for switch case
import java.util.Scanner;

public class StackOption {
    public int maximum;
    public int [] stackArray;
    public int top;

    //Declare an array structure for Stack
    public StackOption (int size) {
        maximum = size;
        stackArray = new int[maximum];
        top = -1;
    }

    //Method to insert data into the array utilizng push method
    public void push (int number) {
        if (top < maximum - 1) {
            stackArray[++top] = number;
        }
        else {
            System.out.println("Push not possible. Please ensure there is space in the array to insert a value.");
        }
    }

    //Method to delete a value/element from the array
    public int pop () {
        if (top >= 0 ) {
            return stackArray[top--];
        }
        else {
            System.out.println("Pop not possible. Not enough elements to be popped (removed). Please insert values first.");
		try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
            return -1;
        }
    }

    //Method to return the most top value
    public int top () {
        if (top >= 0) {
            return stackArray[top];
        }
        else {
            System.out.println("No top value detected. Your array may be empty. Please insert values first.");
		try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			  }
            return -1;
        }
    }

    //Class that handles LinkedLists data structures.
		public void handleStackOperations(Scanner scan) {
			while (true) {
				System.out.println("What do you want to do with the Stack?");
				System.out.println("1. Push Element\n2. Pop Element\n3. Top Element\n4. Exit to Main Menu");
				int option = scan.nextInt();
	
				switch (option) {
					//Case that lets user input numbers into an array.
					//User is prompted to enter values of their liking until they input -1 or if array becomes full.
					case 1:
					System.out.println("Enter the data to push onto the Stack array. Input -1 to finish inputting data.");
						int input = 0;
						while (input != -1) {
							input = scan.nextInt();
							if (input != -1) {
								push(input);
							}
						}
						break;

					//Case that displays deleted number/element.
					//A message is displayed which calls on StackOption class to display deleted number.
					case 2:
					System.out.println("Popped Element: " + pop());
					break;

					//Case that displays most recent (top) number/element.
					//A message is displayed which calls on StackOption class to display top number. 
					case 3:
					System.out.println("Top Element: " + top());
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
