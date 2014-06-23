/* Checkerboard.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Takes an integer argument n 
 * and prints a "checkerboard" made up 
 * of * and spaces of n columns and n rows.
 */

public class Checkerboard {
    public static void main(String[] args) {
        // Store the argument
        int n = Integer.parseInt(args[0]);

        // Print the checkerboard
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Alternates row drawing
                if (i % 2 == 0)
                    System.out.print("* ");
                else
                    System.out.print(" *");
            }
            // Insert a line break after each row
            System.out.print("\n");
        }
    }

}
