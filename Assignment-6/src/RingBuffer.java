/* RingBuffer.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a ring buffer.
 * Dependencies: None
 */

public class RingBuffer {
    private double[] rBuf;
    private int capacity;
    private int size;
    
    private int first;
    private int last;

    public RingBuffer(int capacity) {
        rBuf = new double[capacity];
        this.capacity = capacity;
        size = 0;
        
        first = 0;
        last = 0;
    }

    // return number of items currently in the buffer
    public int size() {
        return size;
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        return size == 0;
    }

    // is the buffer full (size equals capacity)?
    public boolean isFull() {
        return size == capacity;
    }

    // add item x to the end
    public void enqueue(double x) {
        if (!isFull()) {
            rBuf[last] = x;
            size++;
            last++;
            // Perform the wrap-around (when necessary)
            last = last % capacity;
        }
        
        // Do nothing if RingBuffer is full
    }

    // delete and return item from the front
    public double dequeue() {
        if (!isEmpty()) {
            double x = rBuf[first];
            
            rBuf[first] = 0;
            size--;
            first++;
            // Perform the wrap-around (when necessary)
            first = first % capacity;
            
            return x;
        }
        
        // Return zero if RingBuffer is empty (instead of throwing
        // an exception)
        return 0;
    }

    // return (but do not delete) item from the front
    public double peek() {
        if (!isEmpty()) {
            return rBuf[first];
        }
        
        // Return zero if RingBuffer is empty
        return 0;
    }
}
