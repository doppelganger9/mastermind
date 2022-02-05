package com.doppelganger9.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Mastermind game though STDIN/STDOUT
 */
public class App {

    private static String solution;
    private static List<Turn> turns;

    public static void main( String[] args ) {

        turns = new ArrayList<Turn>();
        solution = generateRandomSolution();

        // game loop
        int n = 0;
        BufferedReader br = null;
        boolean win = false;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            while (n < Turn.MAX_NB_TURNS && !win) {
                System.out.println(grid(turns, n));
                System.out.print("Your turn! enter a combination of 4 colors in [R,B,V,J,O,N] or 'q' to quit : ");
                String input = br.readLine();

                final Turn t = new Turn(input, 0, 0, n);

                // parse input
                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }
                if (input == null || input.length() < 4) {
                    System.out.print("Please enter a combination of 4 colors in [R,B,V,J,O,N] or 'q' to quit, you entered : '" + input + "'\n");
                    continue;
                }

                turns.add(t);

                System.out.println("input : " + input);
                System.out.println("-----------\n");

                turns.set(n, computeGameAnswer(n, turns));
                if(t.getNbCorrect().intValue() == solution.length()) {
                    win = true;
                }
                n++;
            }
            System.out.println(grid(turns, n));

            if (win) {
                System.out.println("You won, congratulations!");
            } else {
                System.out.println("You lost.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected static String generateRandomSolution() {
        String s = "";
        for (int i = 0; i<4; i++) {
            int index = new Double(Math.floor((Math.random() * ColorEnum.values().length))).intValue();
            ColorEnum c = ColorEnum.values()[index];
            s += c.name();
        }
		return s;
	}

	protected static Turn computeGameAnswer(int n, List<Turn> turns) {
        Turn current = turns.get(n);

        current.setNbCorrect(countCorrectPositionsAndColors(solution, current.getUserInput()));
        current.setNbMisplaced(countMisplacedColors(solution, current.getUserInput()));

        return current;
    }

    protected static int countMisplacedColors(String expected, String given) {
        int total = 0;
        try {
            String dedup = Stream.of(expected.split("")).distinct().collect(Collectors.joining(""));
            for (int i = 0; i < dedup.length(); i++) {
                if (given.contains(dedup.substring(i,i+1))) {
                    total++;
                }
            }
        } catch (Exception e) {
            // to quickly handle all edge cases... sorry ;-P
            e.printStackTrace();
        }
        return total;
    }

    protected static int countCorrectPositionsAndColors(String expected, String given) {
        int total = 0;
        try {
            for (int i = 0; i < expected.length(); i++) {
                if (expected.charAt(i) == given.charAt(i)) {
                    total ++;
                }
            }
        } catch (Exception e) {
            // to quickly handle all edge cases... sorry ;-P
            e.printStackTrace();
        }
        return total;
    }

    protected static String grid(List<Turn> turns, int n) {
        String s = "|-------------------|\n";
        for (Turn turn : turns) {
            s += turn.toBoardLineOutput();
        }
        if (n < Turn.MAX_NB_TURNS) {
            s+= "|....| . | . | " + (n+1) + "/10 |\n";
        }
        return s + "|-------------------|\n";
    }
}
