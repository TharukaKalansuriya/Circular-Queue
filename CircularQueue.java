public class circularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circularQueue queue = new circularQueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6); //queue in full
		queue.display();  //queue:1 2 3 4 5
		System.out.println("Dequeue: "+queue.dequeue());   //Dequeue: 1
		queue.display();   //Queue: 2 3 4 5 
		System.out.println("Peek: "+queue.peek());   //Peek: 2
		
	}
	
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;
	
	public circularQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = 0;
		rear = -1;
		size = 0;
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	public void enqueue(int item) {
		if(isFull()) {
			System.out.println("Queue is full. Cannot enqueue " + item);
			return;
		}
		rear = (rear + 1) % capacity;
		queue[rear]= item;
		size++;
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Cannot dequeue.");
			return -1;
		}
		int item = queue[front];
		front = (front + 1) % capacity;
		size--;
		return item;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty.Cannot peek.");
			return -1;
		}
		return queue[front];
	}
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Queue: ");
		int count = 0;
		int i = front;
		while(count < size) {
			System.out.println(queue[i] + " ");
			i = (i + 1) % capacity;
			count++;
		}
		System.out.println();
	}

}