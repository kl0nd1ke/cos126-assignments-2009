/* SumThree.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * 
 * Takes three integer arguments, finds
 * their sum, and prints them and the sum.
 * 
 */

public class SumThree {
    public static void main(String[] args) {
        // Store the three integer arguments
        int intOne = Integer.parseInt(args[0]);
        int intTwo = Integer.parseInt(args[1]);
        int intThree = Integer.parseInt(args[2]);
        
        // Calculate the sum of the three integers
        int sum = intOne + intTwo + intThree;
        
        System.out.print(intOne + " + ");
        System.out.print(intTwo + " + ");
        System.out.print(intThree + " = ");
        System.out.print(sum);
    }
}
