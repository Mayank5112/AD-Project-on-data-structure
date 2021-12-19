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
	
			Stack stack = new Stack(2);
			stack.push(2);
			stack.push(33);
		
		System.out.println("size of stack " + stack.size());
		System.out.print("poping all the elements in stack ");
		while(!stack.isEmpty()){
			
			System.out.print(" " + stack.pop() );
		}
		
		System.out.println("\nsize after all the pop " + stack.size());
	
		}
	}
