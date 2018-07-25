class Gqueue<E> {

	public static class EmptyGqueueException extends RuntimeException {
		public EmptyGqueueException() { }
	}

	public static class OverflowGqueueException extends RuntimeException {
		public OverflowGqueueException() { }
	}

	private int max;
	private int num;
	private int front;
	private int rear;
	private E[] que;

	public Gqueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = (E [])new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public E enque(E x) throws OverflowGqueueException {
		if (num >= max)
			throw new OverflowGqueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	public E deque() throws EmptyGqueueException {
		if (num <= 0)
			throw new EmptyGqueueException();
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	public E peek() throws EmptyGqueueException {
		if (num <= 0)
			throw new EmptyGqueueException();
		return que[front];
	}

	public int indexOf(E x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max]  == x)
				return i + front;
		return -1;
	}

	public int search(E x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max]  == x)
				return i + 1;
		return -1;
	}

	public void clear() {
		num = front = rear = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	public void dump() {
		if (num <= 0)
			System.out.println("キューは空です。");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max].toString() + " ");
			System.out.println();
		}
	}
}
