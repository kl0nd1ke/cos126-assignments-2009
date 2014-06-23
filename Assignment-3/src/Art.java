/* Art.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program recursively generates the twindragon fractal
 * to the (N * 2)-th level (N being a command-line argument). This program
 * can easily be modified to generate different fractals (see comments below
 * for fractal suggestions and their requisite values).
 */

public class Art {
    public static void main(String[] args) {
        // Store the user input
        int N = Integer.parseInt(args[0]);

        // Default values
        double x = 0.5;
        double y = 0.25;
        double size = 0.25;
        double angle = Math.PI * 0.5;
        double penSize;

        // Determine the pen size based on N
        if (N < 7) {
            penSize = (7.0 - N) / 250.0;
        } else {
            penSize = 0.001;
        }

        StdDraw.setPenRadius(penSize);

        /*
         * These are fun to play around with; below are some interesting values:
         * 
         * Pythagoras Tree / Levy C curve: pi * 0.25 and pi * 0.25 (note: taller
         * and skinnier trees can be made with smaller angle values, such as pi
         * / 6 and pi / 6)
         * 
         * H-Tree: pi * 0.5 and pi * 0.5
         * 
         * Filled right triangle (45-45-90): pi * 0.75 and pi * 0.75 (note: the
         * height of this triangle is size, which means that the hypotenuse is
         * size * 2 and the sides are (size * 2) / sqrt(2))
         * 
         * Flower (?): pi and pi * 0.5
         * 
         * Twindragon curve: pi * 0.75 and pi * 0.25
         * 
         * Sailboat (?): pi * 0.5 and 0
         * 
         * Curly fractal (another dragon curve?): pi and pi * 0.25
         * 
         * Fern (?): pi * 0.75 and 0
         */
        double angIncr = Math.PI * 0.75;
        double angDecr = Math.PI * 0.25;

        // Double N to make things more interesting
        art(N * 2, x, y, size, angle, angIncr, angDecr);

        System.out.println("Fractal drawing complete!");
    }

    public static void art(int N, double x, double y, double size, double ang,
            double angIncr, double angDecr) {
        double angle = constrainAngle(ang);

        // Calculate the x and y coordinates of the next point 
        // based on the angle
        double xNext = x + Math.cos(angle) * size;
        double yNext = y + Math.sin(angle) * size;

        // Draw the point and the next point
        StdDraw.point(x, y);
        StdDraw.point(xNext, yNext);

        // Animate the drawing
        StdDraw.show(1);

        // Test to see whether the recursion should continue
        if (N > 1) {
            // Recursive call for the left side
            art(N - 1, xNext, yNext, size / Math.sqrt(2), angle + angIncr,
                    angIncr, angDecr);
            // Recursive call for the right side
            art(N - 1, xNext, yNext, size / Math.sqrt(2), angle - angDecr,
                    angIncr, angDecr);
        }
    }

    // Constrain the angle to the range -2pi to 2pi
    public static double constrainAngle(double a) {
        double angle = a;

        while (angle < 0) angle += Math.PI * 2;
        while (angle > Math.PI * 2) angle -= Math.PI * 2;

        return angle;
    }
}
