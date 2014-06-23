/* Huntingtons.java
 * Name: Vladimir Costescu
 * Princeton NetID: costescu
 * Precept: P04A
 * Description: Finds the largest number of CAG repeats in a
 * DNA string and outputs the number and a determination of
 * whether the DNA indicates normality, risk of Huntington's
 * disease, presence of disease, or non-humanness
 * Dependencies: In, Matcher, Pattern
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huntingtons {
    public static void main(String[] args) {
        String regexp = "CAG";

        // Initialize input (as in Harvester.java)
        In in = new In(args[0]);
        String input = in.readAll();

        // Remove whitespace and line breaks
        input = input.replaceAll("[ |\n]", "");

        System.out.println(input);

        // Initialize pattern and matcher (as in Harvester.java)
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);

        // Longest sequence found
        int maxSeq = 1;

        // Temporary variables: length of current sequence and start index of
        // previous sequence found
        int curSeq = 1;
        int start = 0;

        while (matcher.find()) {
            // If current find is directly after previous find
            if (matcher.start() == start) {
                curSeq++;
                start += regexp.length();
            } else {
                if (curSeq > maxSeq) {
                    maxSeq = curSeq;
                }

                // Reset curSeq and start (starting a new sequence)
                curSeq = 1;
                start = matcher.start() + regexp.length();
            }
        }

        // Account for the condition in which the longest sequence ends at the
        // end of the input (and thus isn't accounted for in the else statement)
        if (curSeq > maxSeq) {
            maxSeq = curSeq;
        }

        // Disease status (i.e. not human, normal, high-risk, etc.)
        String status;

        if (maxSeq <= 9 || maxSeq >= 181) {
            status = "not human";
        } else if (maxSeq >= 10 && maxSeq <= 35) {
            status = "normal";
        } else if (maxSeq >= 36 && maxSeq <= 39) {
            status = "high risk";
        } else {
            status = "Huntington's disease";
        }

        // Print out the results
        System.out.println("max number of CAG repeats = " + maxSeq);
        System.out.println(status);
    }
}
