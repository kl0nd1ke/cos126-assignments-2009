/* Sierpinski.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program recursively generates the Sierpinski
 * triangle fractal to the N-th level (N being a command-line argument).
 */

import java.awt.Color;

public class Sierpinski {

    // Colors to make Sierpinski a bit more interesting (see comments below)
    public static final Color[] COLORS = { Color.BLUE, Color.CYAN, Color.GREEN,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW };

    public static void main(String[] args) {
        // Store the user input
        int N = Integer.parseInt(args[0]);
        
        sierpinski(N, 0.5, 0, 0.5);
    }

    public static void sierpinski(int N, double x, double y, double size) {
        triangle(N, x, y, size);
        
        // Test to see whether the recursion should continue
        if (N > 1) {
            // Left triangle recursive call
            sierpinski(N - 1, x - (size / 2), y, size / 2);
            // Right triangle recursive call
            sierpinski(N - 1, x + (size / 2), y, size / 2);
            // Top triangle recursive call
            sierpinski(N - 1, x, y + getTriangleHeight(x, y, size), size / 2);
        }
    }

    public static void triangle(int N, double x, double y, double size) {
        double height = getTriangleHeight(x, y, size);

        // Initialize the x and y coordinate arrays for the vertices
        double[] xCoords = { x, x - size / 2, x + size / 2 };
        double[] yCoords = { y, y + height, y + height };

        // For each level of recursion N, choose a different color from colors
        StdDraw.setPenColor(COLORS[N % COLORS.length]);
        StdDraw.filledPolygon(xCoords, yCoords);
        
        // Draw a black outline around the filled triangle
        StdDraw.setPenColor();
        StdDraw.polygon(xCoords, yCoords);
    }

    public static double getTriangleHeight(double x, double y, double size) {
        // Find the height of an equilateral triangle of side length *size* by
        // using the Pythagorean Theorem in reverse on a right triangle
        // created by cutting the equilateral triangle in half
        double c = size;
        double b = size / 2;
        double a = Math.sqrt(c * c - b * b);

        return a;
    }

}
