package com.quiz.linkedlist;

import java.util.Scanner;

/*  Class SinglyLinkedList  */
public class SinglyLinkedList {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		/* Creating object of class linkedList */
		LinkedList list = new LinkedList();
		System.out.println("Singly Linked List Test\n");
		char ch;
		/* Perform list operations */
		do {
			System.out.println("\nSingly Linked List Operations\n");
			System.out.println("1. Append an element ");
			System.out.println("2. Remove the tail element");
			System.out.println("3. Remove all elements greater than target value");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				list.insertAtEnd(scan.nextInt());
				break;
			case 2:
				int p = list.getSize();
				if (p < 1 || p > list.getSize())
					System.out.println("Invalid position\n");
				else
					list.deleteAtPos(p);
				break;
			case 3:
				System.out.println("Enter integer target element");
				int target = scan.nextInt();
				int size = list.getSize();
				int[] elementsToRemove = new int[size];
				int indx = 0;
				int pos = 1;
				
				//retrive element positions
				Node ptr = list.start;
				while (ptr.getLink() != null) {
					if(ptr.getData() > target) {
						elementsToRemove[indx] = pos;
						indx = indx + 1;
					}
					ptr = ptr.getLink();
					pos = pos + 1;
				}
				if(ptr.getData() > target) {
					elementsToRemove[indx] = pos;
					indx = indx + 1;
				}
				
				//remove all elements by position
				for (int i = 0; i < indx; i++) {
					if(i==0)
						list.deleteAtPos(elementsToRemove[i]);
					else
						list.deleteAtPos(elementsToRemove[i]-1);
				}
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display List */
			list.display();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
