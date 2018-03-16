public class ArrayQueue {
	
	/*
	Il campo principale è la coda, un array la cui
	dimensione viene inizializzata nel costruttore.
	
		Il pivot_begin tiene conto dell'indice in cui è
		posizionato il primo elemento.
		
		Il pivot_end tiene conto dell'indice in cui è
		posizionato l'ultimo elemento.
		
		NOTA BENE: essendo una coda circolare può capitare
					il caso in cui la fine della coda abbia
					un indice minore dell'inizio coda, e
					tra questi due indici potrebbero esserci
					celle dell'array vuoti non utilizzati.
					
		Il campo usati mi tiene conto di quanti elementi
		popolano la coda man mano che si agisce sulla coda.
		Con l'operazione di POP questo valore scende, con
		l'operazione di push invece cresce. Questo mi determina
		quindi quanti elementi riempiono l'array ma non le loro
		posizioni.
		Naturalmente per sapere quanti spazi vuoti disponibili ci sono
		basta sapere:
			coda.length - usati
	 */
	
	private int[] coda;
	private int pivot_begin = 0;
	private int pivot_end = 0;
	private int usati = 0;
	
	public ArrayQueue(int init) {
		this.coda = new int[init];
	}
	
	/*
	public void enqueue(int n) throws FullQueueException
	
	
	Se mi trovo nel caso particolare del primo push
	tutto quello che mi serve di fare è solamente pushare
	il nuovo elemento senza incrementare i pivot, perchè nel primo push
	l'inizio e la fine della coda puntano esclusivamente al primo elemento.
	Mentre per i casi successivi il puntatore alla fine della coda deve crescere
	(con operazione modulo a causa della coda sircolare)
	*/
	
	public void enqueue(int n) throws FullQueueException {
		if (usati == coda.length) throw new FullQueueException();
		
		if (usati == 0) {
			coda[pivot_begin] = n;
			usati++;
			return;
		}
		pivot_end = (pivot_end + 1) % coda.length;
		coda[pivot_end] = n;
		usati++;
	}
	
	
	
	/*
	public int dequeue() throws EmptyQueueException
	
	Dequee ha solo una condizione per impedire il pop
	dalla coda vuota.
	Dopodichè mette da parte il valore che si richiede di
	poppare (ne tiene conto pivot_begin, visto che si poppa
	a inizio coda) e si incrementa quindi pivot_begin per far
	si che pivot_begin-1 sia riutilizzabile per un push.
	Ritorno quindi il valore messo da parte.
	
	
	 */
	public int dequeue() throws EmptyQueueException {
		if (usati == 0) throw new EmptyQueueException();
		int value = coda[pivot_begin];
		coda[pivot_begin] = 0;
		pivot_begin = (pivot_begin + 1) % coda.length ;
		usati--;
		return value;
	}
}
