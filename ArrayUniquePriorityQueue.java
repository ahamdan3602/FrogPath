
public class ArrayUniquePriorityQueue<T> implements UniquePriorityQueueADT<T>{
	private T[] queue;
	private double[] priority;
	private int count;
	
	public ArrayUniquePriorityQueue() {
		queue = (T[])(new Object[10]);
		priority = new double[10];
		count = 0;
	}
	
	
	/*
	 * @param data, is the given data item that will be inserted in the queue. prio, the value of the given data put into the priority array
	 */
	public void add(T data, double prio) {
		//Duplicates Check
		for (int i = 0; i < count; i++) { //Use for loop to check if the data item equals any of the data items that already exist in the queue
			if (data.equals(queue[i])) {
				return;
			}
		}
			
			if (count == queue.length || count == priority.length) { //Expand the queue if the count is equal to the length of the arrays.
				T[] largerQueue = (T[])(new Object[queue.length + 5]);
				double[] largerPriority = new double[priority.length + 5];
				
				for (int i = 0; i < queue.length; i++) { //If elements of the array is full copy the elements of the array into a larger array
					largerQueue[i] = queue[i];
					largerPriority[i] = priority[i];
				}
				queue = largerQueue; //Update queue and priority's reference points.
				priority = largerPriority;
			}
			
			int insertionPoint = count;

			for (int i = 0; i < count; i++) { //Use another for loop to find insertion point
				if (prio == priority[i]) {
					insertionPoint = i+1;
					break;
					
				}else if (prio < priority[i]) {
					insertionPoint = i;
					break;
					} 
			}
			
			
			// Checks if new element is greater than all newly added priorites
		
			//Shift elements of the queue to make space for the insertion point
			for (int i = count - 1; i >= insertionPoint; i--) {
				queue[i+1] = queue[i];
				priority[i+1] = priority[i];
			}
			
			
		
			
			// Place the new items into the priority.
			queue[insertionPoint] = data;
			priority[insertionPoint] = prio;
			count++;
	}
		
		
	/*
	 * @param data, checks if the given data item is already contained in the queue
	 */
	public boolean contains(T data) {
		
		for (int i = 0; i < count; i++) {
			if (data.equals(queue[i])) {
				return true;
			} 
		}
		
		return false;
	}
	
	/*
	 * @return Returns the item with the smallest priority 
	 */
	public T peek() throws CollectionException {
		if (count == 0) {
			throw new CollectionException("PQ is empty");
		}
		
		return queue[0];
	}
	
	/*
	 * @return, removes and returns the item with the smallest priority
	 */
	public T removeMin() throws CollectionException {

		if (count == 0) {
			throw new CollectionException("PQ is empty");
		} 
		T removedData = queue[0];
		
		
		// Shift elements of the array to the left, thus removing the elements
		for (int i = 0; i < count; i++) {
			queue[i] = queue[i+1];
			priority[i] = priority[i+1];
			}
		count--;
		
		return removedData;
	}


	/*
	 * @param data, update the value of the given data item with a new priority
	 */
	
	public void updatePriority(T data, double newPrio) throws CollectionException {
		boolean itemFound = false;
		int index = 0;
		
		for (int i = 0; i < count; i++) {
			if (data.equals(queue[i])) {
				index  = i;
				itemFound = true;
				break;
			} else {
				continue;
			}
		}
		
		if (itemFound == true) {
			for (int i = index; i < count - 1; i++) {
				queue[i] =  queue[i+1];
				priority[i]= priority[i+1];
			}
			count--;
			add(data, newPrio);
		} else if (itemFound == false){
			throw new CollectionException ("Item not found in PQ");
		}
		
	}
	
	
	/*
	 * @return, returns whether the priority queue is empty or not
	 */
	public boolean isEmpty() {
		// Checks if it is empty
		if (count == 0) {
			return true;
		} else {
			return false;
		}

	}
	
	/*
	 * @return, returns the number of items in the priority queue
	 */
	
	public int size() {
		return count;
	}
	
	/*
	 * @return, returns the length of the priority queue
	 */
	public int getLength() {
		return priority.length;
	}
	
	/*
	 * @return, returns a string representation of all the items in the priority queue.
	 */
	public String toString() {
		if (count == 0) { //Empty if count is 0
			return "The PQ is empty";
		}
		String s = ""; // Initialize string
		for (int i = 0; i < count; i++) {
			s += queue[i] + " [" + priority[i] + "]";
			
			if (i < count - 1) {
				s+= ", ";
			}
		}
		
		return s;
	}

}