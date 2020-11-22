package gr1;


public final class App {

    public static  void IsArgsNullOrEmpty(String[] args) throws Exception {
        if (args == null || args.length == 0)
        {
            System.out.println("Please provide range of numbers from 0 to 20");
            throw new Exception();
        }
    }

    public static void PrintResults(String[] args) {

        for (int i = 0; i < args.length; i++)
        {
            int num = 0;
            try
            {
                num = Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e)
            {
                String output = String.format("Please provide numbers only. Input '%s' is not an digit! ", args[i]);
                System.out.println(output);
                throw e;
            }

            if (num % 15 == 0)
            {
                System.out.print("fizzbuzz ");
            }
            else if (num % 3 == 0)
            {
                System.out.print("fizz ");
            }
            else if (num % 5 == 0)
            {
                System.out.print("buzz ");
            }
            else
            {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try
        {
            IsArgsNullOrEmpty(args);
            PrintResults(args);
        }
        catch (Exception e)
        {
            System.exit(0);
        }

    }
}
