import java.util.*;

public class SingleLinkedList
{
	static Scanner sc = new Scanner(System.in);
	public static Node start = null;
	
	public static void main(String args[])
	{
		while(true)
		{
			System.out.println("********************MENU********************");
			System.out.println("0:Exit");
			System.out.println("1: Creation");
			System.out.println("2: Display");
			System.out.println("3: Insert at beginning");
			System.out.println("4: Insert at end");
			System.out.println("5: Insert at any location");
			System.out.println("6: Insert after a given node");
			System.out.println("7: Delete from the beginning");
			System.out.println("8: Delete from the end");
			System.out.println("9: Delete a specific node");
			System.out.println("10: Delete a node from any location");
			System.out.println("11: Search a particular node");
			System.out.println("12: Sort data");
			System.out.println("13: Count number of nodes");
			System.out.println("14: Reverse the SLL");
			System.out.println("********************************************");
			System.out.print("Enter the choice: ");
			int choice = sc.nextInt();
			
			switch (choice) {
				case 0 -> System.exit(0);
				case 1 -> create();
				case 2 -> display();
				case 3 -> insBeg();
				case 4 -> insEnd();
				case 5 -> insAny();
				case 6 -> insAfter();
				case 7 -> delBeg();
				case 8 -> delEnd();
				case 9 -> delSpecific();
				case 10 -> delAny();
				case 11 -> search();
				case 12 -> sort();
				case 13 -> count();
				case 14 -> reverse();
				default -> System.out.println("Wrong choice.");
			}
		}
	}
	
	//Inserting a node at the beginning of the LL
	public static Node insBeg()
	{
		Node curr = new Node();
		System.out.println("Enter the mark of the new student");
		curr.mark = sc.nextInt();
		curr.head = null;
		if(start == null)
			start = curr;
		else
		{
			curr.head = start;
			start = curr;
		}
		
		return start;
	}
	
	//Creating the LL
	public static void create()
	{
		Node p = new Node(), q;
		System.out.print("Enter the mark of student: ");
		p.mark = sc.nextInt();
		p.head = null;
		start = p;
		System.out.println("Do you want to add a new node? (yes-1, no-0)");
		int option = sc.nextInt();
		while(option != 0)
		{
			q = new Node();
			System.out.print("Enter the mark of student: ");
			q.mark = sc.nextInt();
			q.head = null;
			p.head = q;
			p = q;
			System.out.println("Do you want to add an new node? (yes-1, no-0)");
			option = sc.nextInt();
		}
	}
	
	//Traversing the LL
	public static void display()
	{
		System.out.println("Display the marks of all students");
		Node temp = start;
		while(temp != null)
		{
			System.out.println(temp.mark);
			temp = temp.head;
		}
	}
	
	//Inserting a node at the end of the LL
	public static void insEnd()
	{
		Node curr = new Node();
		System.out.println("Enter the mark of the new student");
		curr.mark = sc.nextInt();
		curr.head = null;
		
		Node temp = start;
		//if(start == null)
		//start = curr;
		//else
		//{
		while(temp.head != null)
		{
			temp = temp.head;
		}
		
		temp.head = curr;
		//}
	}
	
	//Inserting a node at any location of the LL
	public static void insAny()
	{
		Node curr, temp = start;
		int i = 1, c = 0, loc;
		System.out.print("Enter the location : ");
		loc = sc.nextInt();
		while(temp != null)
		{
			c++;
			temp = temp.head;
		}
		if(loc == 1)
			insBeg();
		else if(loc == c+1)
			insEnd();
		else
		{
			temp = start;
			while(i < loc-1)
			{
				temp = temp.head;
				i++;
			}
			curr = new Node();
			System.out.print("Enter marks of the student");
			curr.mark = sc.nextInt();
			curr.head = temp.head;
			temp.head = curr;
		}
	}
	
	//Inserting a node after a given node
	public static void insAfter()
	{
		System.out.print("Enter the mark of the student after which you want to insert the new mark : ");
		int mark1 = sc.nextInt();
		Node temp = start;
		while(temp != null)
		{
			if(temp.mark == mark1)
			{
				Node curr = new Node();
				System.out.print("Enter mark of the new student : ");
				curr.mark = sc.nextInt();
				curr.head = temp.head;
				temp.head = curr;
			}
			temp = temp.head;
		}
	}
	
	//Deleting a node from the beginning
	public static void delBeg()
	{
		Node temp1;
		if(start == null)
		{
			System.out.println("Memory Underflow");
			System.exit(0);
		}
		else
		{
			temp1 = start;
			start = temp1.head;
			temp1.head = null;
		}
	}
	
	//Deleting a node from the end of the SLL
	public static void delEnd()
	{
		Node temp1, temp2;
		temp2 = null;
		if(start == null)
		{
			System.out.println("Memory Underflow");
			System.exit(0);
		}
		else
		{
			temp1 = start;
			while(temp1.head != null)
			{
				temp2 = temp1;
				temp1 = temp1.head;
			}
			temp2.head = null;
		}
	}
	
	//Delete a node from any location
	public static void delAny()
	{
		System.out.print("Enter any location : ");
		int loc = sc.nextInt();
		int count = 0, i = 1;
		
		Node temp1, temp2 = null;
		Node temp = start;
		while(temp != null)
		{
			count++;
			temp = temp.head;
		}
		if(loc == 1)
			delBeg();
		else if(loc == count)
			delEnd();
		else if(start == null)
		{
			System.out.println("Memory Underflow");
			System.exit(0);
		}
		else
		{
			temp1 = start;
			while(i < loc)
			{
				temp2 = temp1;
				temp1 = temp1.head;
				i++;
			}
			
			temp2.head = temp1.head;
			temp1.head = null;
		}
	}
	
	//Deleting a specific node
	public static void delSpecific()
	{
		System.out.print("Enter the mark of the student you want to delete : ");
		int marks = sc.nextInt();
		Node temp1, temp2;
		temp2 = null;
		if(start == null)
		{
			System.out.println("Memory Underflow");
			System.exit(0);
		}
		else
		{
			temp1 = start;
			while(temp1 != null)
			{
				if(temp1.mark == marks)
					break;
				
				temp2 = temp1;
				temp1 = temp1.head;
			}
			temp2.head = temp1.head;
			temp1.head = null;
		}
	}
	
	//Searching for node
	public static void search()
	{
		System.out.print("Enter the mark you want to search : ");
		int marks = sc.nextInt();
		
		Node temp = start;
		int flag = 0;
		
		while(temp != null)
		{
			if(temp.mark == marks)
			{
				flag = 1;
				break;
			}
			temp = temp.head;
		}
		
		if(flag == 1)
			System.out.println(marks + " is present.");
		else
			System.out.println(marks + " is not present.");
	}
	
	//Sorting the SLL
	public static void sort()
	{
		Node p1,p2;
		int temp;
		
		for(p1 = start; p1 != null; p1 = p1.head)
		{
			for(p2 = p1.head; p2 != null; p2 = p2.head)
			{
				if(p1.mark > p2.mark)
				{
					temp = p1.mark;
					p1.mark = p2.mark;
					p2.mark = temp;
				}
			}
		}
	}
	
	//Counting the number of nodes
	public static void count()
	{
		Node temp;
		int count = 0;
		temp = start;
		
		while(temp != null)
		{
			count++;
			temp = temp.head;
		}
		
		System.out.println("Number of nodes = " +count);
	}
	
	//Reversing the SLL
	public static void reverse()
	{
		Node p1,p2,p3;
		p1 = null;
		p2 = start;
		p3 = p2.head;
		p2.head = null;
		
		while(p3 != null)
		{
			p1 = p2;
			p2 = p3;
			p3 = p3.head;
			p2.head = p1;
		}
		
		start = p2;
	}
      public static class Node
    {
	  int mark;
	  Node head;
	  Node tail;
    }

}