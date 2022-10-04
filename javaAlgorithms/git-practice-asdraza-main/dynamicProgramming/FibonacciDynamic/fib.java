public class fib {

        public static int fib(final int n)
        {
            //Array for storing fibonacci numbers
            int fib[] = new int[n+2];
            int i;
            fib[0] = 0;
            fib[1] = 1;
            // main
            for (i = 2; i <= n; i++)
            {
                //add last 2 numbers and store in array
                fib[i] = fib[i-1] + fib[i-2];
            }
            // return the final array
            return fib[n];
        }
        public static void main (String args[])
        {
            int n = 15;
            System.out.println(fib(n));
            for(int i = 0; i < n; i++){
                System.out.print(fib(i) +" ");
            }
        }

}
