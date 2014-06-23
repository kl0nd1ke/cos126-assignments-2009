/* BeadTracker.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Takes an arbitrary number of frames as command line 
 * arguments and prints the movement of the beads between two frames
 * Dependencies: Blob, BlobFinder, Picture, Luminance, StdOut
 */

public class BeadTracker {

    public static void main(String[] args) {
        int tau = 180;
        int P = 25;
        double maxDistance = 25.0;

        /*
         * picOne, bfOne, and beadsOne are initialized ahead of time in order to
         * work properly with the loop and the effort to reduce memory usage
         */

        Picture picOne = new Picture(args[0]);
        BlobFinder bfOne = new BlobFinder(picOne, tau);
        Blob[] beadsOne = bfOne.getBeads(P);

        // This is set to null so that the compiler doesn't WINE
        // (sorry, couldn't resist the Linux joke)
        Blob[] beadsTwo = null;

        for (int i = 0; i < args.length - 1; i++) {
            // Recycle BlobFinders to minimize space usage
            beadsTwo = beadsOne;

            // These are already set to the right values when the loop starts
            if (i != 0) {
                picOne = new Picture(args[i]);
                bfOne = new BlobFinder(picOne, tau);
                beadsOne = bfOne.getBeads(P);
            }

            for (int c = 0; c < beadsTwo.length; c++) {
                Blob currentBead = beadsTwo[c];
                Blob closestBead = beadsOne[0];

                for (int d = 0; d < beadsOne.length; d++) {
                    Blob tempBead = beadsOne[d];

                    // If tempBead is closer to currentBead than closestBead,
                    // make it the new closestBead
                    if (currentBead.distanceTo(tempBead) < currentBead
                            .distanceTo(closestBead)) {
                        closestBead = tempBead;
                    }
                }

                double distance = currentBead.distanceTo(closestBead);

                if (distance <= maxDistance && distance != 0) {
                    StdOut.printf("%8.4f", distance);
                    StdOut.println();
                }
            }

            StdOut.println();
        }
    }

}
