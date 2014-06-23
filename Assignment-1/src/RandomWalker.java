/* RandomWalker.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program takes an argument n and
 * simulates the walk of a person walking in a random direction
 * at each step (N, S, E, W, expressed in x,y coordinates).
 */

public class RandomWalker {
    public static void main(String[] args) {
        // Store the argument
        int n = Integer.parseInt(args[0]);

        // Declare x,y coordinates (assigned as 0),
        // a random variable (unassigned), and the squared distance (unassigned)
        int x = 0;
        int y = 0;
        double rand;
        double sqDist;

        for (int i = 0; i < n; i++) {
            rand = Math.random();
            // Divide range of 0 to 1 into 4 parts, designate
            // each part as a step in a different direction
            if (rand < 0.25)
                x--;
            else if (rand < 0.5)
                x++;
            else if (rand < 0.75)
                y--;
            else
                y++;
            // Print the x,y coordinates
            System.out.println("(" + x + "," + y + ")");
        }
        // Compute and print the square distance
        sqDist = (x * x) + (y * y);
        System.out.println("squared distance = " + sqDist);
    }
}
