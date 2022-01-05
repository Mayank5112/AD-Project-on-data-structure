import java.util.EmptyStackException;



public class Stack {
	
	private int arr[];
	private int size;
	private int index = 0;
	
	public Stack(int size) {
		this.size = size;
		arr = new int[size];
	}
	
	public void push(int element) {
		
		if (isFull()) {
			System.out.println("the Stack is full ");
		}
		
		arr[index] = element;
		index++;
	}
	
	public int pop() {
		
		if (isEmpty()) {
			System.out.println("list is empty");
		}
		return arr[--index];
	}
	
	public void  print(){
		int i = 1;
		System.out.println("all the elements");
		while (i<=size)
		{
			System.out.println(pop());
				i++;
			}
		
	}
	public boolean isEmpty() {
		if (index == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (index == size) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return index;
	}
	
	public static void main(String [] args){
// 		creat a new stack give it a name --> *s*
// 		use push method to add elements to the stack --> *s*.push(*element*)
// 		use stack pop to remove the element --> *s*.pop();
// 		use print method to display all the elements in the stack --> *s*.print();
		Stack stack = new Stack(2);
		stack.push(2);
		stack.push(33);
		stack.print();

		
	}
}
