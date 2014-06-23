/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac TSPTimer.java
 *  Execution:    java TSPTimer N
 *  Dependencies: Tour.java Point.java
 *
 *  Time the two heuristics by generated random instances of size N.
 *
 *  % java TSPTimer N
 *
 *************************************************************************/

public class TSPTimer {

    public static void main(String[] args) {
        int SIZE = 600;
        int N = Integer.parseInt(args[0]);
        long start, stop;
        double elapsed;


        // generate data and run nearest insertion heuristic
        start = System.currentTimeMillis();
        Tour tour1 = new Tour();
        for (int i = 0; i < N; i++) {
            double x = Math.random() * SIZE;
            double y = Math.random() * SIZE;
            Point p = new Point(x, y);
            tour1.insertNearest(p);
        }
        System.out.println("Tour distance = " + tour1.distance());
        stop = System.currentTimeMillis();
        elapsed = (stop - start) / 1000.0;
        System.out.println("Nearest insertion:  " + elapsed + " seconds");


        // generate data and run smallest insertion heuristic
        start = System.currentTimeMillis();
        Tour tour2 = new Tour();
        for (int i = 0; i < N; i++) {
            double x = Math.random() * SIZE;
            double y = Math.random() * SIZE;
            Point p = new Point(x, y);
            tour2.insertSmallest(p);
        }
        System.out.println("Tour distance = " + tour2.distance());
        stop = System.currentTimeMillis();
        elapsed = (stop - start) / 1000.0;
        System.out.println("Smallest insertion:  " + elapsed + " seconds");



    }

}
