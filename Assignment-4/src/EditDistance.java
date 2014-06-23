/* EditDistance.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Finds the alignment of two strings x and y with the least 
 * edit distance and prints out the alignment and penalties for each character. 
 */

public class EditDistance {
    public static void main(String[] args) {
        // Read the two strings using StdIn
        String x = StdIn.readString();
        String y = StdIn.readString();

        printOpt(x, y, opt(x, y));
    }

    /* Generates and populates opt (2-D array) */
    public static int[][] opt(String x, String y) {
        int M = x.length();
        int N = y.length();
        int[][] opt = new int[M + 1][N + 1];

        for (int i = M; i >= 0; i--) {
            for (int j = N; j >= 0; j--) {
                // If not at last column or row
                if (i < M && j < N) {
                    // Option 1: x char and y char
                    int a = opt[i + 1][j + 1]
                            + penalty(x.charAt(i), y.charAt(j));
                    // Option 2: x char and a space
                    int b = opt[i + 1][j] + penalty('-', y.charAt(j));
                    // Option 3: y char and a space
                    int c = opt[i][j + 1] + penalty(x.charAt(i), '-');

                    // Choose the correct option
                    opt[i][j] = minThree(a, b, c);
                } else {
                    // Last row
                    if (i == M)
                        opt[i][j] = 2 * (N - j);
                    // Last column
                    else
                        opt[i][j] = 2 * (M - i);
                }
            }
        }

        return opt;
    }

    /* Takes opt (2-D array) and prints the optimal alignment and penalties */
    public static void printOpt(String x, String y, int[][] opt) {
        int M = x.length();
        int N = y.length();

        // Strings that will be printed
        String X = "";
        String Y = "";
        String penalties = "";

        // Initial conditions
        int i = 0, j = 0;
        while (i < M || j < N) {
            // Not last row or column
            if (i < M && j < N) {
                // Option 1: x char and y char
                int a = opt[i + 1][j + 1] + penalty(x.charAt(i), y.charAt(j));
                // Option 2: x char and a space
                int b = opt[i + 1][j] + penalty(x.charAt(i), '-');
                // Option 3: y char and a space
                int c = opt[i][j + 1] + penalty('-', y.charAt(j));

                if (opt[i][j] == a) { // option 1 chosen
                    X += x.charAt(i) + " ";
                    Y += y.charAt(j) + " ";
                    penalties += penalty(x.charAt(i), y.charAt(j)) + " ";
                    i++;
                    j++;
                } else if (opt[i][j] == b) { // option 2 chosen
                    X += x.charAt(i) + " ";
                    Y += "- ";
                    penalties += penalty(x.charAt(i), '-') + " ";
                    i++;
                } else if (opt[i][j] == c) { // option 3 chosen
                    X += "- ";
                    Y += y.charAt(j) + " ";
                    penalties += penalty('-', y.charAt(j)) + " ";
                    j++;
                }
            }
            // Last column (same as option 2 above)
            else if (i < M) {
                X += x.charAt(i) + " ";
                Y += "- ";
                penalties += penalty(x.charAt(i), '-') + " ";
                i++;
            }
            // Last row (same as option 3 above)
            else {
                X += "- ";
                Y += y.charAt(j) + " ";
                penalties += penalty('-', y.charAt(j)) + " ";
                j++;
            }
        }

        System.out.println("Edit distance: " + opt[0][0]);
        System.out.print(X + "\n" + Y + "\n" + penalties);
    }

    /* Find the minimum of three integers */
    public static int minThree(int a, int b, int c) {
        int min;

        if (a <= b)
            min = a;
        else
            min = b;

        if (c < min)
            min = c;

        return min;
    }

    /* Calculate the penalty (2, 1, or 0) */
    public static int penalty(char a, char b) {
        if (a == '-' || b == '-')
            return 2;
        else if (a != b)
            return 1;
        else
            return 0;
    }
}