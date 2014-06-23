/* Distinct.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program takes three integer arguments, 
 * checks to see how many distinct values there are, and 
 * prints the results.
 */

public class Distinct {
    public static void main(String[] args) {
        // Stores the values entered by the user
        int intOne = Integer.parseInt(args[0]);
        int intTwo = Integer.parseInt(args[1]);
        int intThree = Integer.parseInt(args[2]);

        // Compute the number of distinct values
        int numDistinct = 0;
        if (intOne != intTwo)
            numDistinct++;
        if (intTwo != intThree)
            numDistinct++;
        if (intOne != intThree)
            numDistinct++;
        if (numDistinct == 0)
            numDistinct++;

        // Print the results
        if (numDistinct == 1)
            System.out.println("There is 1 distinct value.");
        else
            System.out
                    .println("There are " + numDistinct + " distinct values.");
    }

}
