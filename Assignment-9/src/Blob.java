/* Blob.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a blob
 * Dependencies: none
 */

public class Blob {
    private int mass;
    private int sumOfXCoords;
    private int sumOfYCoords;

    // construct an empty blob
    public Blob() {
        mass = 0;
        sumOfXCoords = 0;
        sumOfYCoords = 0;
    }

    // add a pixel (i, j) to the blob
    public void add(int i, int j) {
        mass++;
        sumOfXCoords += i;
        sumOfYCoords += j;
    }

    // return number of pixels added = its mass
    public int mass() {
        return mass;
    }

    // return distance from the center of mass of this blob to b
    public double distanceTo(Blob b) {
        double thisXCenterOfMass = getXCenterOfMass();
        double thisYCenterOfMass = getYCenterOfMass();

        double bXCenterOfMass = b.getXCenterOfMass();
        double bYCenterOfMass = b.getYCenterOfMass();

        double distance = Math.sqrt(Math.pow(
                thisXCenterOfMass - bXCenterOfMass, 2)
                + Math.pow(thisYCenterOfMass - bYCenterOfMass, 2));

        return distance;
    }

    // return string representation of this blob
    public String toString() {
        return String.format("%2d (%8.4f, %8.4f)", mass, getXCenterOfMass(),
                getYCenterOfMass());
    }

    private double getXCenterOfMass() {
        return (double) sumOfXCoords / mass;
    }

    private double getYCenterOfMass() {
        return (double) sumOfYCoords / mass;
    }
}
