public class de_queue {
	private static int front, rear, capacity;
	private static int queue[];
	
	de_queue(int size) {
		front = rear = 0;
		capacity = size;
		queue = new int[capacity];
	}
	
	// insert an element into the queue
	static void enqueue(int item)  {
		// check if the queue is full
		if (capacity == rear) {
			System.out.println("\nQueue is full\n");
			
		}
		
		// insert element at the rear
		else {
			queue[rear] = item;
			rear++;
		}
		
	}
	static void dequeuelast(){
		if(rear==front && rear==0){
			System.out.println("list is empty");
		}
		else if(rear==front && rear==1){
			front = 0;
			rear = 0 ;
					}
		else
		{
			rear--;
		}
	}
	//remove an element from the queue
	static void dequeue()  {
		// check if queue is empty
		if (front == rear) {
			System.out.println("\nQueue is empty\n");
			
		}
		
		// shift elements to the right by one place uptil rear
		else {
			int x = 	Queue.queueFront();
			System.out.println("element which is deleted " + x);
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}
			
			
			// set queue[rear] to 0
			if (rear < capacity)
				queue[rear] = 0;
			
			// decrement rear
			rear--;
		}
		
	}
	
	// print queue elements
	static void queueDisplay()
	{
		int i;
		if (front == rear) {
			System.out.println("Queue is Empty\n");
			
		}
		
		// traverse front to rear and print elements
		for (i = front; i < rear; i++) {
			
			System.out.println(queue[i]);;
			
			
		}
		
	}
	
	// print front of queue
	static int queueFront()
	{
		if (front == rear) {
			System.out.println("Queue is Empty");
			
		}
		
		return queue[front];
	}
	public static void main(String []args){
	
		de_queue queue = new de_queue(5);
		enqueue(1);
		enqueue(2);
		enqueue(2);
		enqueue(2);
		enqueue(2);
		
		dequeuelast();
		queueDisplay();
	}
}
