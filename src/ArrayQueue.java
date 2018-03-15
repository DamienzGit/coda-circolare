public class ArrayQueue {
	
	private int[] coda;
	private int pivot = 0;
	
	public ArrayQueue(int n) {
		coda = new int[n];
	}
	
	public void enqueue(int n) throws FullQueueException{
		if (pivot == coda.length) throw new FullQueueException();
		coda[pivot] = n;
		pivot++;
		
	}
	
	public int dequeue() throws EmptyQueueException{
		// Se la coda è vuota
		if (pivot == 0) throw new EmptyQueueException();
		// se è piena prendi l'ultimo
		if (pivot == coda.length) {
			int ret_value = coda[coda.length-1];
			pivot-= 1;
			return ret_value;
		}
		
		int returnvalue = coda[pivot-1];
		pivot--;
		return returnvalue;
	}
	
	public String printa() {
		return coda.toString();
	}
}
