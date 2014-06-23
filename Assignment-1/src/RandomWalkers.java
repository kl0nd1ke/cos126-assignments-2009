/* RandomWalkers.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program takes two arguments n and t, runs t
 * simulations of the walk of a person walking in a random direction
 * at each step (N, S, E, W, expressed in x,y coordinates), and computes
 * and outputs the mean squared distance across the trials.
 */

public class RandomWalkers {
    public static void main(String[] args) {
        // Store the arguments
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        // Declare x,y coordinates (assigned as 0), a random
        // variable (unassigned), the squared distance (unassigned), and
        // the mean squared distance (assigned as 0)
        int x;
        int y;
        double rand;
        double sqDist;
        double avDist = 0;

        // Outer loop runs all trials, resets x and y
        // coordinates at the beginning of each trial
        for (int i = 0; i < t; i++) {
            x = 0;
            y = 0;
            // Inner loop runs each individual trial
            for (int j = 0; j < n; j++) {
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
            }
            // Compute squared distance and increment average distance
            // based on the squared distance
            sqDist = (x * x) + (y * y);
            avDist += (sqDist / t);
        }
        System.out.println("mean squared distance = " + avDist);
    }
}
