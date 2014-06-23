/* GuitarHero.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a guitar player using 37 instances of
 * GuitarString that correspond to certain keys on the keyboard in
 * positions that attempt to mimic a piano keyboard.
 * Dependencies: RingBuffer, GuitarString, StdDraw, StdAudio
 */

public class GuitarHero {
    public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static final int NUM_NOTES = KEYBOARD.length();

    public static void main(String[] args) {
        GuitarString[] gStrings = new GuitarString[NUM_NOTES];

        // Initialize guitar strings
        for (int i = 0; i < NUM_NOTES; i++) {
            gStrings[i] = new GuitarString(440 * Math.pow(2, (i - 24.0) / 12.0));
        }

        while (true) {
            // check if the user has typed a key; if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);

                // Ignore keys that aren't in KEYBOARD
                if (index != -1) {
                    gStrings[index].pluck();
                }

            }

            double sample = 0;

            // compute the superposition of samples
            for (int i = 0; i < NUM_NOTES; i++) {
                sample += gStrings[i].sample();
            }

            // send the result to the sound card
            StdAudio.play(sample);

            for (int i = 0; i < NUM_NOTES; i++) {
                gStrings[i].tic();
            }

        }
    }
}
