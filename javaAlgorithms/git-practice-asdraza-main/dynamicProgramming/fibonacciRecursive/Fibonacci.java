public class Fibonacci
{
    public static int fib(final int n)
    {
        //base case
        if(n <= 1)
            return n;
        // recursive case
        return fib(n-2) + fib(n-1);
    }
    public static void main(String args[])
    {
        int Number = 15;
        System.out.print("The Fibonacci Series is : ");
        for (int i = 0; i < Number; i++)
        {
            System.out.print(fib(i) + " ");
        }
    }
}

