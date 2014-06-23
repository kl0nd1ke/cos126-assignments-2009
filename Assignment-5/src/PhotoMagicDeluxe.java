/* PhotoMagicDeluxe.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Uses an LFSR to "encrypt" an image by generating
 * pseudo-random values for each red, green, and blue value at each pixel.
 * This version of PhotoMagic allows for an alphanumeric password instead of
 * a binary string.
 * Dependencies: LFSR, PhotoMagic, Picture 
 */

public class PhotoMagicDeluxe {
    public final static String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
    		"abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";
    
    public static void main(String[] args) {
        String picName = args[0];
        /* This is the only line of code that differs from the 
         * main method of PhotoMagic */
        String seed = stringToBinary(args[1]);
        int tap = Integer.parseInt(args[2]);

        LFSR lfsr = new LFSR(seed, tap);
        Picture p = new Picture(picName);
        PhotoMagic.generate(p, lfsr);

        p.show();
        p.save("X" + picName);
    }
    
    /* Converts a string into binary (represented by a string) */
    public static String stringToBinary(String password) {
        String binary = "";
        
        for (int i = password.length() - 1; i >= 0; i--) {
            binary += intToBinary(base64.indexOf(password.charAt(i)));
        }
        
        return binary;
    }
    
    /* Converts an integer into binary (represented by a string) */
    public static String intToBinary(int i) {
        int temp = i;
        String binary = "";
        
        while (temp > 0) {
            binary += temp % 2;
            temp /= 2;
        }
        
        return binary;
    }
}
