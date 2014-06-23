/* Tour.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Implements a tour in the Traveling Salesperson Problem
 * Dependencies: Point, StdDraw
 */

public class Tour {
    private Node start;

    private class Node {
        private Point p;
        private Node next;

        // create one Node
        public Node(Point p) {
            this.p = p;
            this.next = null;
        }
    }

    // create an empty tour
    public Tour() {
        start = null;
    }

    // create a 4 point tour for debugging
    public Tour(Point a, Point b, Point c, Point d) {
        Point[] points = { a, b, c, d };
        int numPoints = points.length;

        // Initialize the first node
        Node curNode = new Node(points[0]);
        start = curNode;

        // Initialize the rest of the nodes
        for (int i = 1; i < numPoints; i++) {
            curNode.next = new Node(points[i]);
            curNode = curNode.next;
        }

        curNode.next = start;
    }

    // print the tour to standard output
    public void show() {
        Node curNode = start;

        // Ignore empty tours
        if (curNode != null) {
            // Traverse the tour and print out each point
            do {
                System.out.println(curNode.p);
                curNode = curNode.next;
            } while (curNode != start);
        }
    }

    // draw the tour
    public void draw() {
        StdDraw.clear();

        Node curNode = start;

        // Ignore empty tours
        if (curNode != null) {
            // Traverse the tour and draw each point
            do {
                curNode.p.drawTo(curNode.next.p);
                curNode = curNode.next;
            } while (curNode != start);
        }
    }

    // return the total distance of the tour
    public double distance() {
        double distance = 0;

        Node curNode = start;

        // Ignore empty tours
        if (curNode != null) {
            // Traverse the tour and increment distance
            do {
                distance += curNode.p.distanceTo(curNode.next.p);
                curNode = curNode.next;
            } while (curNode != start);
        }

        return distance;
    }

    // insert p using smallest insertion heuristic
    public void insertSmallest(Point p) {
        // Special case for first point inserted
        if (start == null) {
            start = new Node(p);
            start.next = start;
        } else {
            // Start from the beginning
            Node curNode = start;
            double curDistIncr = curNode.p.distanceTo(p)
                    + p.distanceTo(curNode.next.p)
                    - curNode.p.distanceTo(curNode.next.p);

            Node bestNode = curNode;
            double smallestDistIncr = curDistIncr;

            do {
                // On the first loop iteration this will not execute because
                // closestDistance and curDistance are the same initially
                if (smallestDistIncr > curDistIncr) {
                    bestNode = curNode;
                    smallestDistIncr = curDistIncr;
                }

                // Prepares for the next iteration (like i++ in a for loop)
                curNode = curNode.next;
                curDistIncr = curNode.p.distanceTo(p)
                        + p.distanceTo(curNode.next.p)
                        - curNode.p.distanceTo(curNode.next.p);
            } while (curNode != start);

            // After the best node after which to insert the new node has been
            // found, perform the actual insertion
            Node newNode = new Node(p);
            newNode.next = bestNode.next;
            bestNode.next = newNode;
        }
    }

    // insert p using nearest neighbor heuristic
    public void insertNearest(Point p) {
        // Special case for first point inserted
        if (start == null) {
            start = new Node(p);
            start.next = start;
        } else {
            // Start from the beginning
            Node curNode = start;
            double curDistance = curNode.p.distanceTo(p);

            Node closestNode = curNode;
            double closestDistance = curDistance;

            do {
                // On the first loop iteration this will not execute because
                // closestDistance and curDistance are the same initially
                if (closestDistance > curDistance) {
                    closestNode = curNode;
                    closestDistance = curDistance;
                }

                // Prepares for the next iteration (like i++ in a for loop)
                curNode = curNode.next;
                curDistance = curNode.p.distanceTo(p);
            } while (curNode != start);

            // After the best node after which to insert the new node has been
            // found, perform the actual insertion
            Node newNode = new Node(p);
            newNode.next = closestNode.next;
            closestNode.next = newNode;
        }
    }

    // main method for testing
    public static void main(String[] args) {
        // Nothing here
    }
}
