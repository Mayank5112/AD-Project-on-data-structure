import java.util.*;

public class DLL
{
	static Scanner sc = new Scanner(System.in);
	
	public static Node start = null;
	public static Node end = null;
	
	//Creating new nodes for DLL
	public static void create()
	{
		Node p = new Node(), q;
		
		System.out.print("Enter mark of a student");
		p.mark = sc.nextInt();
		p.tail = null;
		p.head = null;
		start = end = p;
		
		System.out.println("Do you want to add new node to DLL(yes-1, no-0)");
		int option = sc.nextInt();
		while(option != 0)
		{
			q = new Node();
			System.out.print("Enter mark of new student : ");
			q.mark = sc.nextInt();
			q.tail = p;
			p.head = q;
			q.head = null;
			p = q;
			end = q;
			
			System.out.println("Do you want to add new node to DLL(yes-1, no-0)");
			option = sc.nextInt();
		}
	}
	
	//Displaying the nodes
	public static void display()
	{
		System.out.println("Traverse the DLL in forward direction");
		Node temp = start;
		
		while(temp != null)
		{
			System.out.println(temp.mark);
			temp = temp.head;
		}
		
		System.out.println("Traverse the DLL in backwards direction");
		Node temp1 = end;
		
		while(temp1 != null)
		{
			System.out.println(temp1.mark);
			temp1 = temp1.tail;
		}
	}
	
	//Inserting new nodes at the start of the DLL
	public static void insBeg()
	{
		Node curr = new Node();
		System.out.print("Enter mark of a new student ");
		curr.mark = sc.nextInt();
		curr.tail = null;
		curr.head = null;
		if(start == null && end == null)
			start = end = curr;
		else
		{
			curr.head = start;
			start.tail = curr;
			start = curr;
		}
	}
	
	//Inserting new nodes at the end of the DLL
	public static void insEnd()
	{
		Node curr = new Node();
		System.out.print("Enter mark of a new student ");
		curr.mark = sc.nextInt();
		curr.tail = null;
		curr.head = null;
		
		if(start == null && end == null)
			start = end = curr;
		else
		{
			curr.tail = end;
			end.head = curr;
			end = curr;
		}
		
	}
	
	//Inserting a new node at a particular location of the DLL
	public static void insAny()
	{
		Node curr = new Node();
		System.out.print("Enter mark of a new student ");
		curr.mark = sc.nextInt();
		curr.tail = null;
		curr.head = null;
		
		System.out.print("Enter location: ");
		int loc = sc.nextInt(), count = 0, i = 1;
		Node temp = start;
		while(temp != null)
		{
			count++;
			temp = temp.head;
		}
		
		if(loc == 1)
			insBeg();
		else if(loc == (count + 1))
			insEnd();
		else
		{
			temp = start;
			while(i < loc-1)
			{
				temp = temp.head;
				i++;
			}
			curr.head = temp.head;
			curr.tail = temp;
			temp.head.tail = curr;
			temp.head = curr;
		}
	}
	
	//Delete node from the beginning
	public static void delBeg()
	{
		Node temp = start;
		if(start == null)
		{
			System.out.println("Memory Underflow");
			return;
		}
		else
		{
			start = start.head;
			temp.head = null;
			start.tail = null;
			
			/*Check if this works later*/
//			start = start.head;
//			start.tail.head = null;
//			start.tail = null;
		}
	}
	
	//Delete node from the end
	public static void delEnd()
	{
		if(start == null)
		{
			System.out.println("Memory Underflow");
			return;
		}
		else
		{
			end = end.tail;
			end.head.tail = null;
			end.head = null;
		}
	}
	
	//Deleting a node from any location
	public static void delAny()
	{
		if(start == null)
		{
			System.out.println("Memory Underflow");
			return;
		}
		else
		{
			System.out.print("Enter location : ");
			int loc = sc.nextInt();
			Node temp = start;
			int count = 0, i = 1;
			
			while(temp != null)
			{
				count++;
				temp = temp.head;
			}
			if(loc == 1)
				delBeg();
			else if(loc == count)
				delEnd();
			else
			{
				temp = start;
				while(i < loc)
				{
					i++;
					temp = temp.head;
				}
				temp.tail.head = temp.head;
				temp.head.tail = temp.tail;
				temp.head = temp.tail = null;
			}
			
		}
	}
	public static class Node{
		int mark;
		Node head;
		Node tail;
	}
	
	//Driver
	public static void main(String args[])
	{
		int choice;
		while(true)
		{
			System.out.println("*******MENU******");
			System.out.println("0:Exit");
			System.out.println("1:Create");
			System.out.println("2:Display");
			System.out.println("3:Insert at beginning");
			System.out.println("4:Insert at the end");
			System.out.println("5:Insert at any location");
			System.out.println("6:Delete a node from the beginning");
			System.out.println("7:Delete a node from the end");
			System.out.println("8:Delete from any location");
			System.out.println("*****************");
			
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 0 : System.exit(0);
				break;
			case 1 : create();
				break;
			case 2 : display();
				break;
			case 3 : insBeg();
				break;
			case 4: insEnd();
				break;
			case 5: insAny();
				break;
			case 6: delBeg();
				break;
			case 7: delEnd();
				break;
			case 8: delAny();
				break;
			default : System.out.println("Wrong choice");
			}
		}
	}
}
