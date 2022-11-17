
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Mocock
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueElement<T> head;
	private QueueElement<T> tail;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * @return  true if the queue is empty and false otherwise
	 */
	public boolean isEmpty () {
		if (head == null && tail == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * @return the element at the head of the queue
	 * Uses try-catch to stop crash
	 */
	public T peek () throws NoSuchElementException {
		try {
			if (!isEmpty()) {
				return head.getElement();
			} else {
				throw new NoSuchElementException();
			}
		}
		catch (NullPointerException | NoSuchElementException e) {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		try {
			if (head != null) {
				if (head.getNext() == null) {
					/*
					Makes sure head and tail are correct
					 */
					head = null;
					tail = null;
				} else {
					head = head.getNext();
				}
			} else {
				throw new NoSuchElementException();
			}
		}
		catch (NullPointerException e) {
			tail = null;
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 * @param element
	 */
	public void enqueue (T element) {
		if (isEmpty()) {
			/*
			Create an element and set the head and tail to it
			 */
			QueueElement<T> newQE = new QueueElement<>(element, null);
			head = newQE;
			tail = head;
		} else {
			/*
			Make a new element and change the tail
			 */
			QueueElement<T> newQE = new QueueElement<>(element, null);
			tail.setNext(newQE);
			tail = newQE;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		/*
		Makes sure queue is empty so no error is thrown
		 */
		if (!isEmpty()) {
			QueueElement<T> currentItem = head;
            /*
            Loops through each item
             */
			do {
				System.out.println(currentItem.getElement().toString());
				currentItem = currentItem.getNext();
			}
			while (currentItem != null);
		}
		else {
			System.out.println("The queue is empty.");
		}

	}
}
