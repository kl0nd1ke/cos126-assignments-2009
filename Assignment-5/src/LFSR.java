/* LFSR.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a linear feedback shift register (LFSR).
 * Dependencies: None
 */

public class LFSR {
    private int N;
    private int[] reg;
    private int tap;

    public LFSR(String seed, int tap) {
        N = seed.length();
        this.tap = tap;
        reg = new int[N];

        for (int i = 0; i < N; i++) {
            // Takes advantage of the fact that 1 comes after 0 in Unicode
            reg[N - 1 - i] = seed.charAt(i) - '0';
        }
    }

    public int step() {
        // Store the last bit and the tap bit (before we shift the LFSR)
        int lastBit = reg[N - 1];
        int tapBit = reg[tap];

        // Shift the LFSR to the left by one bit
        for (int i = N - 1; i > 0; i--) {
            reg[i] = reg[i - 1];
        }

        // XOR the two bits
        reg[0] = lastBit ^ tapBit;

        return reg[0];
    }

    public int generate(int k) {
        // pRand: "pseudo-random"
        int pRand = 0;

        for (int i = k; i > 0; i--) {
            pRand = pRand * 2 + step();
        }

        return pRand;
    }

    public String toString() {
        String binSeq = "";

        // Build the binary sequence string
        for (int i = N - 1; i >= 0; i--) {
            binSeq += reg[i];
        }

        return binSeq;
    }
}
