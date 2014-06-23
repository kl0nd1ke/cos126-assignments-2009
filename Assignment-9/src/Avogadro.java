/* Avogadro.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Calculate Boltzmann and Avogadro constants using 
 * data from BeadTracker
 * Dependencies: StdIn
 */

public class Avogadro {

    public static void main(String[] args) {
        double D = calculateD();
        double T = 297;
        double eta = 9.135e-4;
        double rho = 0.5e-6;
        double R = 8.31457;
        
        double k = (D * 6 * Math.PI * eta * rho) / T;
        double nA = R / k;
        
        System.out.println("Boltzmann = " + k);
        System.out.println("Avogadro = " + nA);
    }
    
    public static double calculateD() {
        double mpp = 0.175e-6;
        double sigmaR = 0;
        double n = 0;
        
        while (!StdIn.isEmpty()) {
            double r = StdIn.readDouble();
            sigmaR += r * r * mpp * mpp;
            n++;
        }
        
        return sigmaR / (2 * n);
    }
}
