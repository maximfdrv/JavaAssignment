package gr1;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public final class App {

    static final String FIZZBUZZ = "fizzbuzz";
    static final String BUZZ = "buzz";
    static final String FIZZ = "fizz";
    static final String LUCKY = "lucky";
    static final String INTEGER = "integer";

    /*
        Method checked if args is null or empty, user will get a correct message
    */
    public static void IsArgsNullOrEmpty(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            System.out.println("Please provide range of numbers from 0 to 20");
            throw new Exception();
        }
    }

    /*
        Method print out correct output
    */
    public static void PrintResultsAndStatistics(String[] args) {

        Dictionary<String, Integer> dict = new Hashtable<String, Integer>();

        for (int i = 0; i < args.length; i++) {
            int num = 0;
            try
            {
                //parse string to int, will throw if string is not a digit
                num = Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e)
            {
                //catch exception if input is not a digit, giving user correct message, rethrow exception
                String output = String.format("Please provide numbers only. Input '%s' is not an digit! ", args[i]);
                System.out.println(output);
                throw e;
            }

            //using mudulus for the output logic
            if (num % 15 == 0) {
                System.out.print(FIZZBUZZ + " ");
                ModifyDictionary(FIZZBUZZ, dict);
            } else if (num % 10 == 3) {
                System.out.print(LUCKY + " ");
                ModifyDictionary(LUCKY, dict);
            } else if (num % 3 == 0) {
                System.out.print(FIZZ + " ");
                ModifyDictionary(FIZZ, dict);
            } else if (num % 5 == 0) {
                System.out.print(BUZZ + " ");
                ModifyDictionary(BUZZ, dict);
            } else {
                System.out.print(num + " ");
                ModifyDictionary(INTEGER, dict);
            }
        }
        PrintStatistics(dict);
    }

    /*
        Method print out statistic
    */
    private static void PrintStatistics(Dictionary<String, Integer> dict)
    {
        System.out.println("");
        Enumeration<String> keys = dict.keys();
        Enumeration<Integer> vals = dict.elements();

        while(keys.hasMoreElements())
        {
            System.out.println(keys.nextElement() + ": " + vals.nextElement() );
        }
    }

    /*
        Method adds correct keys and if keys exists add count to dictionary
    */
    private static void ModifyDictionary(String key, Dictionary<String, Integer> dict)
    {
        if (dict.get(key) != null)
        {
            dict.put(key, dict.get(key) + 1);
        }
        else
        {
            dict.put(key, 1);
        }
    }

    /*
        Main method.
    */
    public static void main(String[] args) throws Exception {
        try
        {
            IsArgsNullOrEmpty(args);
            PrintResultsAndStatistics(args);
        }
        catch (Exception e)
        {
            System.exit(1);
        }
        finally
        {
            System.exit(0);
        }
    }
}
