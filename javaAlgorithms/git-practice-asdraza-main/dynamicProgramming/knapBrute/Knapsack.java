public class Knapsack {

    //Give the bigger integer
    public static int max_int(int a, int b)
    {
        if(a > b)
            return a;
        else
            return b;
    }

    //give the bigger value
    public static int knapsack(int W, int[] w, int[] vals, int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        //If Weight of n > capacity of w, then don't include
        if (w[n - 1] > W)
            return knapsack(W, w, vals, n - 1);

            //Give the term that's included and the one that's not included
        else
            return max_int(vals[n - 1] + knapsack(W - w[n - 1], w,vals,n-1),
                    knapsack(W, w, vals, n - 1));
    }

    public static void main(String args[])
    {
        int vals[] = new int[] { 22, 10, 412 };
        int w[] = new int[] { 20, 30, 50 };
        int W = 50;
        int n = vals.length;
        System.out.println(knapsack(W, w, vals, n));
    }
}