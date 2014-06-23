/* NBody.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: This program simulates the motion of N bodies
 * gravitationally affecting each other (i.e. the solar system).
 */

public class NBody {
    public static void main(String[] args) {
        // Read N and the universe radius, and define G and deltaT
        int N = StdIn.readInt();
        double R = StdIn.readDouble();
        double G = 6.67e-11;
        double deltaT = 25000.0;

        // Create empty arrays of size N
        double[] xPos = new double[N];
        double[] yPos = new double[N];
        double[] xVel = new double[N];
        double[] yVel = new double[N];
        double[] mass = new double[N];
        String[] image = new String[N];

        // Populate the arrays with initial values
        for (int i = 0; i < N; i++) {
            xPos[i] = StdIn.readDouble();
            yPos[i] = StdIn.readDouble();
            xVel[i] = StdIn.readDouble();
            yVel[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }

        // Set up StdDraw
        StdDraw.setXscale(-R, R);
        StdDraw.setYscale(-R, R);
        StdAudio.play("2001.mid");
        
        // This loop increments time (and runs infinitely)
        while (true) {

            // Draw background image
            StdDraw.picture(0, 0, "starmap.jpg");

            // Draw each planet
            for (int i = 0; i < N; i++) {
                StdDraw.picture(xPos[i], yPos[i], image[i]);
                // System.out.println("The position of planet " + i + " is (" +
                // xPos[i] + "," + yPos[i] + ").");
            }
            
            // Show the drawn objects, with a 30 ms pause
            StdDraw.show(30);

            // Create empty arrays of size N
            double[] xPosInst = new double[N];
            double[] yPosInst = new double[N];
            double[] xVelInst = new double[N];
            double[] yVelInst = new double[N];

            // This loop copies the instantaneous attributes of the
            // bodies into the arrays defined above
            for (int i = 0; i < N; i++) {
                xPosInst[i] = xPos[i];
                yPosInst[i] = yPos[i];
                xVelInst[i] = xVel[i];
                yVelInst[i] = yVel[i];
            }

            // This loop goes through each body (array[i] is Body 1)
            for (int i = 0; i < N; i++) {
                double xForce = 0;
                double yForce = 0;

                // This loop goes through each OTHER body (array[p] is Body 2)
                for (int p = 0; p < N; p++) {
                    if (i != p) {
                        // Calculates the difference between the X and Y
                        // coordinates of the bodies
                        double xDiff = xPos[p] - xPos[i];
                        double yDiff = yPos[p] - yPos[i];

                        // Calculates the perpendicular distance (i.e. radius)
                        // between the bodies
                        double radius = Math.sqrt(Math.pow((xDiff), 2)
                                + Math.pow((yDiff), 2));
                        // Calculates the gravitational force between the two
                        // bodies
                        double force = (G * (mass[i] * mass[p]))
                                / Math.pow(radius, 2);

                        // Calculates the components of the force and adds them
                        // to each net force variable (i.e. horizontal and
                        // vertical)
                        xForce += (force * xDiff) / radius;
                        yForce += (force * yDiff) / radius;
                    }
                }

                // Calculate the X and Y components of the acceleration
                double xAccel = xForce / mass[i];
                double yAccel = yForce / mass[i];

                // Calculate the X and Y components of the velocity
                xVelInst[i] += deltaT * xAccel;
                yVelInst[i] += deltaT * yAccel;

                // Calculate the X and Y components of the position
                xPosInst[i] += deltaT * xVelInst[i];
                yPosInst[i] += deltaT * yVelInst[i];
            }

            // This loop updates the attributes of the bodies with the
            // instantaneous attributes previously calculated for each body
            for (int i = 0; i < N; i++) {
                xPos[i] = xPosInst[i];
                yPos[i] = yPosInst[i];
                xVel[i] = xVelInst[i];
                yVel[i] = yVelInst[i];
            }
        }
    }
}