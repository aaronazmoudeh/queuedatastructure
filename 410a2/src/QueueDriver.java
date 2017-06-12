
class QueueDriver {
	
	public static void main (String[] args) {
		// testing array queue
		Queue arrayQueue = new Queue("array");
		System.out.println("Testing array queue...");
		arrayQueue.enq(12);
		arrayQueue.enq(14);
		arrayQueue.enq(16);
		arrayQueue.enq(18);
		arrayQueue.enq(20);
		arrayQueue.enq(22);
		// array queue now looks like {12, 14, 16, 18, 20, 22}
		System.out.println("front: " + arrayQueue.front());
		System.out.println("size: " + arrayQueue.size());
		arrayQueue.deq();
		arrayQueue.deq();
		// array queue now looks like {16, 18, 20, 22}
		System.out.println("front: " + arrayQueue.front());
		System.out.println("size: " + arrayQueue.size());
		System.out.println("empty?: " + arrayQueue.empty());
		arrayQueue.deq();
		arrayQueue.deq();
		arrayQueue.deq();
		arrayQueue.deq();
		// array queue now looks like {}
		System.out.println("empty?: " + arrayQueue.empty());
		
		// testing linked cell queue
		Queue linkedQueue = new Queue("linked");
		System.out.println("Testing linked cell queue...");
		linkedQueue.enq(12);
		linkedQueue.enq(14);
		linkedQueue.enq(16);
		linkedQueue.enq(18);
		linkedQueue.enq(20);
		linkedQueue.enq(22);
		// linked cell queue now looks like {12, 14, 16, 18, 20, 22}
		System.out.println("front: " + linkedQueue.front());
		System.out.println("size: " + linkedQueue.size());
		linkedQueue.deq();
		linkedQueue.deq();
		// linked cell queue now looks like {16, 18, 20, 22}
		System.out.println("front: " + linkedQueue.front());
		System.out.println("size: " + linkedQueue.size());
		System.out.println("empty?: " + linkedQueue.empty());
		linkedQueue.deq();
		linkedQueue.deq();
		linkedQueue.deq();
		linkedQueue.deq();
		// linked cell queue now looks like {}
		System.out.println("empty?: " + linkedQueue.empty());
		
		// both the queue of array implementation and the queue of
		// linked cell implementation use the same commands to produce
		// the same queue, just with different implementation methods
	}

}

class Queue {
	protected QueueImpl imp;
	
	public Queue(String s) {
		
		if (s.equalsIgnoreCase("array")) {
			
			imp = new QueueImplArray();
		}
		else {
			
			imp = new QueueImplLinked();
		}
	}
	public QueueImpl enq(Object o){
		return imp.enq(o);
	}
	public QueueImpl deq() {
		return imp.deq();
	}
	public Object front() {
		return imp.front();
	}
	public int size() {
		return imp.size();
	}
	public boolean empty() {
		return imp.empty();
	}
	
}

interface QueueImpl {
	QueueImpl enq(Object o);
	QueueImpl deq();
	Object front();
	int size();
	boolean empty();
	
}

class QueueImplArray implements QueueImpl {
	private Object[] queue_array = new Object[200];
	private int size = 0;
	private int head = 100;
	private int tail = 100;

	@Override
	public QueueImpl enq(Object item) {
		
		queue_array[tail] = item;
		tail++;
		size++;
		return this;
	}

	@Override
	public QueueImpl deq() {
		
		queue_array[head] = null;
		head++;
		size--;
		return this;
	}

	@Override
	public Object front() {

		return queue_array[head];
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean empty() {
		
		return size == 0;
	}
	
	
}

class QueueImplLinked implements QueueImpl {
	private int size = 0;
	private Cell head = null;
	private Cell tail = null;
	
	
	@Override
	public QueueImpl enq(Object item) {
		Cell newCell = new Cell(item, null);
		if (empty()) {
			head = newCell;
		}
		else {
			tail.next = newCell;
		}
		tail = newCell;
		size++;
		return this;
	}

	@Override
	public QueueImpl deq() {

		if (tail == head) {
			tail = null;
		}
		head = head.next;
		size--;
		return this;
	}

	@Override
	public Object front() {
		return head.data;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean empty() {
		return head == null;
	}
	
}

	class Cell {
		Object data;
		Cell next;
		public Cell(Object data, Cell next) {
			this.data = data;
			this.next = next;
		}
	}