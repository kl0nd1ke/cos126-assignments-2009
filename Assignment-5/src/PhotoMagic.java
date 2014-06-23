/* PhotoMagic.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Uses an LFSR to "encrypt" an image by generating
 * pseudo-random values for each red, green, and blue value at each pixel.
 * Dependencies: LFSR, Picture, java.awt.Color 
 */

import java.awt.Color;

public class PhotoMagic {

    public static void main(String[] args) {
        String picName = args[0];
        String seed = args[1];
        int tap = Integer.parseInt(args[2]);

        LFSR lfsr = new LFSR(seed, tap);
        Picture p = new Picture(picName);
        generate(p, lfsr);

        p.show();
        p.save("X" + picName);
    }

    public static void generate(Picture p, LFSR lfsr) {
        for (int i = 0; i < p.width(); i++) {
            for (int j = 0; j < p.height(); j++) {
                // Get the RGB components of pixel (i, j)
                int r = p.get(i, j).getRed();
                int g = p.get(i, j).getGreen();
                int b = p.get(i, j).getBlue();

                // XOR the RGB components with pseudo-random 8-bit integers
                r = r ^ lfsr.generate(8);
                g = g ^ lfsr.generate(8);
                b = b ^ lfsr.generate(8);

                p.set(i, j, new Color(r, g, b));
            }
        }
    }
}
