import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Prompt.java - Uses BufferedReader.
 * Provides utilities for user input.  This enhances the BufferedReader
 * class so our programs can recover from "bad" input, and also provides
 * a way to limit numerical input to a range of values.
 * <p>
 * The advantages of BufferedReader are speed, synchronization, and piping
 * data in Linux.
 *
 * @author your name
 * @since date
 */

public class Prompt {
    // BufferedReader variables

    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    /**
     * Prompts user for string of characters and returns the string.
     *
     * @param ask The prompt line
     * @return The string input
     */
    public static String getString(String ask) {
        System.out.print(ask);

        try {
            return reader.readLine();
        } catch (Exception e) {
            System.out.println("Please enter a valid string!!!");
            return "";
        }
    }

    /**
     * Prompts the user for a character and returns the character.
     *
     * @param ask The prompt line
     * @return The character input
     */
    public static char getChar(String ask) {
        System.out.print(ask);

        try {
            return (char)reader.read();
        } catch (Exception e) {
            System.out.println("Please enter a valid character!!!");
            return ' ';
        }
    }

    /**
     * Prompts the user for an integer and returns the integer.
     *
     * @param ask The prompt line
     * @return The integer input
     */
    public static int getInt(String ask) {
        System.out.print(ask);

        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Please enter a valid integer!!!");
            System.exit(1);
            return 0;
        }
    }

    /**
     * Prompts the user for an integer using a range of min to max,
     * and returns the integer.
     *
     * @param ask The prompt line
     * @param min The minimum integer accepted
     * @param max The maximum integer accepted
     * @return The integer input
     */
    public static int getInt(String ask, int min, int max) {
        System.out.print(ask);

        try {
            int readerInt = Integer.parseInt(reader.readLine());
            if(min <= readerInt && max >= readerInt){
                return readerInt;
            }
            throw new Exception();

        } catch (Exception e) {
            System.out.println("Please enter a valid integer!!!");
            System.exit(1);
            return 0;
        }
    }

    /**
     * Prompts the user for a double and returns the double.
     *
     * @param ask The prompt line
     * @return The double input
     */
    public static double getDouble(String ask) {
        System.out.print(ask);

        try {
            return Double.parseDouble(reader.readLine());
        } catch (Exception e) {
            System.out.println("Please enter a valid integer!!!");
            return 0;
        }
    }

    /**
     * Prompts the user for a double and returns the double.
     *
     * @param ask The prompt line
     * @param min The minimum double accepted
     * @param max The maximum double accepted
     * @return The double input
     */
    public static double getDouble(String ask, double min, double max){
        System.out.print(ask);

        try {
            double readerDouble = Double.parseDouble(reader.readLine());
            if(min <= readerDouble && max >= readerDouble){
                return readerDouble;
            }
            throw new Exception();

        } catch (Exception e) {
            System.out.println("Please enter a valid double!!!");
            return 0;
        }
    }
}