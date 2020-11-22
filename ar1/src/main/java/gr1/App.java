package gr1;


public final class App {

    static final String FIZZBUZZ = "fizzbuzz";
    static final String BUZZ = "buzz";
    static final String FIZZ = "fizz";

    /*
        Method checked if args is null or empty, user will get a correct message
    */
    public static  void IsArgsNullOrEmpty(String[] args) throws Exception {

        if (args == null || args.length == 0)
        {
            System.out.println("Please provide range of numbers from 0 to 20");
            throw new Exception();
        }
    }

    /*
        Method print out correct output
    */
    public static void PrintResults(String[] args) {

        for (int i = 0; i < args.length; i++)
        {
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
            if (num % 15 == 0)
            {
                System.out.print(FIZZBUZZ + " ");
            }
            else if (num % 3 == 0)
            {
                System.out.print(FIZZ + " ");
            }
            else if (num % 5 == 0)
            {
                System.out.print(BUZZ + " ");
            }
            else
            {
                System.out.print(num + " ");
            }
        }
    }

    /*
        Main method.
    */
    public static void main(String[] args) throws Exception {
        try
        {
            IsArgsNullOrEmpty(args);
            PrintResults(args);
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
