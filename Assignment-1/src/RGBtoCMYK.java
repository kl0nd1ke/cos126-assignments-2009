/* RGBtoCMYK.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program takes three integer arguments 
 * representing the RGB values, converts them to CMYK, and 
 * prints the results.
 */

public class RGBtoCMYK {
    public static void main(String[] args) {
        // Store the values for RGB
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);

        // Convert from RGB to CMYK
        double white = Math.max(red / 255.0, Math.max(green / 255.0,
                blue / 255.0));
        double cyan = (white - (red / 255.0)) / white;
        double magenta = (white - (green / 255.0)) / white;
        double yellow = (white - (blue / 255.0)) / white;
        double black = 1.0 - white;

        // Print the results
        System.out.println("cyan    = " + cyan);
        System.out.println("magenta = " + magenta);
        System.out.println("yellow  = " + yellow);
        System.out.println("black   = " + black);
    }
}
