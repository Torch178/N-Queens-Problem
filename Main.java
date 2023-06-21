package cs2130;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int n;
        int j;
        long startTime, endTime, duration;
        Nqueens queensProblem;

        
        /*Run the Nqueens problem for several value of n and time the results*/
        for (int i = 2; i < 16; i++) {
            queensProblem = new Nqueens(i);
            System.out.println("i = " + i);
            if(i<12) {
                startTime = System.nanoTime();
                queensProblem.bruteForceFindSolution();
                endTime = System.nanoTime();
                System.out.println("Bruteforce");
                queensProblem.printSolution();
                duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
                System.out.printf("Running time: %f ms\n\n", duration / 1000000.0);
            }

            startTime = System.nanoTime();
            queensProblem.backtrackingFindSolution();
            endTime = System.nanoTime();
            System.out.println("Backtracking");
            queensProblem.printSolution();
            duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
            System.out.printf("Running time: %f ms\n\n", duration / 1000000.0);
            
        }

        NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
        String result;

    }
}
