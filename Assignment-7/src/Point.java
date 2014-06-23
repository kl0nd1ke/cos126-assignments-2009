/* Point.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a point in the Cartesian xy plane
 * Dependencies: StdDraw
 */

public class Point {
    private double x;
    private double y;
    
    // create the point (x, y)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // return string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // draw point using standard draw
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw line segment between the two points
    public void drawTo(Point b) {
        StdDraw.line(x, y, b.x, b.y);
    }

    // return Euclidean distance between the two points
    public double distanceTo(Point b) {
        double xDiff = b.x - x;
        double yDiff = b.y - y;
        
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
