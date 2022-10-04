public class Knapsack
{
    public static int knapsack(final int W, final int w[], final int values[],int n)
    {
        // initialize array
        int []l= new int[W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int k = W; k >= 0; k--) {
                if (w[i - 1] <= k) {// find maximum value
                    l[k] = Math.max(l[k],
                            l[k - w[i - 1]] + values[i - 1]);
                }
            }
        }
        // return max value
        return l[W];
    }

    // Driver code
    public static void main(String[] args)
    {
        int values[] = { 22, 10, 412 };
        int w[] = { 20, 30, 50 };
        int W = 50;
        int n = values.length;
        System.out.print(knapsack(W, w, values, n));
    }
}
