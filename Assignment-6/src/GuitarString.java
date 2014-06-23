/* GuitarString.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a guitar string using a ring buffer and
 * the Karplus-Strong updating algorithm.
 * Dependencies: RingBuffer
 */

public class GuitarString {
    private static final double ENERGY_DECAY = 0.996;
    private static final double SAMPLE_RATE = 44100;
    private int N;
    private RingBuffer rBuf;
    private int tics = 0;

    // create a guitar string of the given frequency
    public GuitarString(double frequency) {
        N = (int) Math.round(SAMPLE_RATE / frequency);
        rBuf = new RingBuffer(N);

        // Enqueue N zero values
        for (int i = 0; i < N; i++) {
            rBuf.enqueue(0);
        }
    }

    // create a guitar string whose size
    // and initial values are given by the array
    public GuitarString(double[] init) {
        N = init.length;
        rBuf = new RingBuffer(N);
        
        // Enqueue the values of init
        for (int i = 0; i < N; i++) {
            rBuf.enqueue(init[i]);
        }
    }

    // set the buffer to white noise
    public void pluck() {
        rBuf = new RingBuffer(N);
        
        // Math.random() generates a number between 0 and 1; we want
        // a number between -0.5 and 0.5
        for (int i = 0; i < N; i++) {
            rBuf.enqueue(Math.random() - 0.5);
        }
    }

    // advance the simulation one time step
    public void tic() {
        double sampOne = rBuf.dequeue();
        double sampTwo = rBuf.peek();
        
        // Karplus-Strong update
        rBuf.enqueue(0.5 * (sampOne + sampTwo) * ENERGY_DECAY);
        
        // Update tics
        tics++;
    }

    // return the current sample
    public double sample() {
        return rBuf.peek();
    }

    // return number of tics
    public int time() {
        return tics;
    }
}
