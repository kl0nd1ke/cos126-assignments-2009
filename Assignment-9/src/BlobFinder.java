/* BlobFinder.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Takes a picture and finds the blobs (connected bunches of 
 * pixels whose luminance is above an arbitrary threshold)
 * Dependencies: Blob, Picture, Luminance, Color, ArrayList
 */

import java.awt.Color;
import java.util.ArrayList;

public class BlobFinder {
    private Picture picture;

    // Convention: 0 means black, 1 means unmarked, 2 means marked
    private int[][] markedPixels;
    private Blob currentBlob;

    private ArrayList<Blob> blobs;
    private ArrayList<Blob> beads;

    // find all blobs in the given picture using the given luminance threshold
    public BlobFinder(Picture picture, double threshold) {
        // Create an empty Picture of the same dimensions as picture
        this.picture = new Picture(picture.width(), picture.height());
        // Create a new array in which to store marked pixels
        markedPixels = new int[this.picture.height()][this.picture.width()];

        // Use the thresholding technique to identify foreground pixels and
        // eliminate background pixels (set foreground pixels to white and
        // background pixels to black)
        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                if (Luminance.lum(picture.get(i, j)) < threshold) {
                    this.picture.set(i, j, Color.BLACK);
                    markedPixels[j][i] = 0;
                } else {
                    this.picture.set(i, j, Color.WHITE);
                    markedPixels[j][i] = 1;
                }
            }
        }

        // Initialize other necessary instance variables
        currentBlob = new Blob();
        blobs = new ArrayList<Blob>();
        beads = new ArrayList<Blob>();

        // Find all the blobs
        findBlobs();
    }

    // return all beads: beads are blobs that are at least P pixels large
    public Blob[] getBeads(int P) {
        for (Blob b : blobs) {
            if (b.mass() >= P)
                beads.add(b);
        }

        Object[] objectsArray = beads.toArray();
        Blob[] beadsArray = new Blob[objectsArray.length];

        for (int i = 0; i < objectsArray.length; i++) {
            beadsArray[i] = (Blob) objectsArray[i];
        }

        return beadsArray;
    }

    // print out all blobs
    public void show() {
        System.out.println("Blobs: ");

        for (Blob b : blobs) {
            System.out.println(b);
        }
    }

    private void findBlobs() {
        currentBlob = new Blob();

        for (int j = 0; j < markedPixels.length; j++) {
            for (int i = 0; i < markedPixels[0].length; i++) {
                if (markedPixels[j][i] == 1) {
                    dfs(i, j);

                    // Add the found blob and then clear currentBlob
                    blobs.add(currentBlob);
                    currentBlob = new Blob();
                }
            }
        }
    }

    private void dfs(int i, int j) {
        markedPixels[j][i] = 2;
        currentBlob.add(i, j);

        /*
         * Each recursive call below tests whether or not the respective
         * adjacent pixel has been marked and runs only if the pixel is unmarked
         */

        // North pixel
        if (j != 0 && markedPixels[j - 1][i] == 1)
            dfs(i, j - 1);
        // East pixel
        if (i != markedPixels[0].length - 1 && markedPixels[j][i + 1] == 1)
            dfs(i + 1, j);
        // South pixel
        if (j != markedPixels.length - 1 && markedPixels[j + 1][i] == 1)
            dfs(i, j + 1);
        // West pixel
        if (i != 0 && markedPixels[j][i - 1] == 1)
            dfs(i - 1, j);
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        int tau = 180;
        int P = 25;

        BlobFinder bf = new BlobFinder(picture, tau);

        // Print the results
        bf.show();
        System.out.println();
        System.out.println("Beads:");
        Blob[] beads = bf.getBeads(P);
        for (int i = 0; i < beads.length; i++) {
            System.out.println(beads[i]);
        }
    }
}
