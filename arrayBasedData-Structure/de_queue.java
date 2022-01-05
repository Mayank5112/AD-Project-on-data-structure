public class de_queue {
	private static int front, rear, capacity;
	private static int queue[];
	
	de_queue(int size) {
		front = rear = -1;
		capacity = size;
		queue = new int[capacity];
	}
	
	// insert an element into the queue
	static void enqueueLast(int item)  {
		// check if the queue is full
		if (isFull() || capacity == rear+1) {
			System.out.println("\nQueue is full\n");
		}
		// insert element at the rear
		else {
			rear++;
			queue[rear] = item;
			if(front == -1 ){
				front++;
			}
		}
	}
	static void enqueueFront(int item){
		//check if the is full
		if(isFull() || front == 0){
			System.out.println("\nQueue is full\n");
		}
		else if(front == -1)
			enqueueLast(item);
		else
		{
			front--;
			queue[front] = item;
		}
	}
	static void dequeuelast(){
		if(isEmpty()){
			System.out.println("list is empty");
		}
		else if(front==rear){
			front=rear=-1;
		}
		else {
			rear--;
		}
	}
	//remove an element from the queue
	static void dequeueFront()  {
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		else if(front==rear){
			front=rear=-1;
		}
		else {
			front++;
		}
	}
	
	// print queue elements
	static void queueDisplay()
	{
		int i;
		if (isEmpty()) {
			System.out.println("Queue is Empty\n");
		}
		
		// traverse front to rear and print elements
		for (i = front; i < rear+1; i++) {
			
			System.out.println(queue[i]);
			
		}
		
	}
	
	// print front of queue
	static int queueFront()
	{
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		}
		return queue[front];
	}
	static boolean isFull(){
		return (front+rear) == (capacity-1);
	}
	static boolean isEmpty(){
		return (front==-1);
	}
	public static void main(String []args){
//	    creat new de_queue and name it
//		use enqueueLast to add elements at the last
//		use enqueueFront to add item to the front
//		use queueDisplay() to display the queue
//		use dequeuelast to remove last element
//		use dequeueFront to remove first element in the queue
		de_queue queue = new de_queue(7);
		enqueueLast(1);
		enqueueLast(2);
		enqueueLast(4);
		enqueueLast(6);
		enqueueLast(3);
		enqueueFront(55);
		queueDisplay();
	}
}
