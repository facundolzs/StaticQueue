package queue;

public class Queue {

    private static final int DEFAULT_SIZE = 10;
    private int[] queueArray;
    private int arraySize, size = 0, front = 0, rear = 0;

    public Queue(int arraySize) {
        this.arraySize = arraySize;
        this.queueArray = new int[arraySize];
    }

    public Queue() {
        this(DEFAULT_SIZE); // constructor chaining
    }

    /**
     * Check if the Queue is empty or not
     *
     * @return true if no items added
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Check if the Queue is fully or not
     *
     * @return true if the rear is equal to the total size of the Queue
     */
    public boolean isFull() {
        return rear == arraySize;
    }

    /**
     * Returns current items number on the Queue (It's a primitive operation? idk x1000)
     *
     * @return number of items
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns item at the front of the Queue (without removing it)
     *
     * @return front item
     */
    public int peekFront() {

        if (!isEmpty()) {
            return queueArray[front];
        }

        return -1;
    }

    /**
     * Returns item at the rear of the Queue (without removing it)
     *
     * @return rear item
     */
    public int peekRear() {

        if (!isEmpty()) {
            return queueArray[rear - 1];
        }

        return -1;
    }

    /**
     * Adds a new item to the rear of the Queue
     *
     * @param value (new value to add)
     * @return added item
     */
    public int enQueue(int value) {

        queueArray[rear] = value;
        rear++;
        size++;

        return value;
    }

    /**
     * Removes the front item of the Queue
     *
     * @return removed item
     */
    public int deQueue() {

        int removed = queueArray[front];

        for (int i = 0; i < rear - 1; i++) {
            queueArray[i] = queueArray[i + 1];
        }

        if (rear < arraySize) {
            queueArray[rear] = 0;
        }

        rear--;
        size--;

        return removed;
    }

}
