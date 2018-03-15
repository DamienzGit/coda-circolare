public class TestQueue {
	public static void main(String[] args) {
        /*
        stampa i numeri da 1 a 7
         */
		ArrayQueue Q = new ArrayQueue(3);
		try{
			Q.enqueue(1);
			Q.enqueue(2);
			Q.enqueue(3);
			// Q.enqueue(4);
			System.out.println(Q.dequeue());
			Q.enqueue(4);
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			Q.enqueue(5);
			System.out.println(Q.dequeue());
			Q.enqueue(6);
			Q.enqueue(7);
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			// System.out.println(Q.dequeue()); coda vuota!
		}
		catch (EmptyQueueException e) {
			System.out.println("coda vuota!");
		}
		catch (FullQueueException f) {
			System.out.println("coda piena!");
		}
	}
}