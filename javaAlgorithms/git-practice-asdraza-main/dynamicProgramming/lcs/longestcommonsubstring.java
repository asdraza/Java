public class longestcommonsubstring
{
    public static int LCS(final String sOne, final String sTwo)
    {
        return lcs(sOne,  sTwo, 0, 0);
    }

    public static int lcs(final String sOne,final String  sTwo, int q,int k)
    {
        //initalize table
        int dp[][]=new int[2][k+1];
        int l=0;
       //iterate through the array
        for(int i=1;i<=q;i++)
        {
            for(int j=1;j<=k;j++)
            {
                //count++ when theres a match
                if(sOne.charAt(i-1)== sTwo.charAt(j-1))
                {
                    dp[i%2][j]=dp[(i-1)%2][j-1]+1;

                    if(dp[i%2][j]>l)
                    {
                        l=dp[i%2][j];
                    }
                }
                //otherwise count stays the same
                else
                {
                    dp[i%2][j]=0;
                }
            }
        }
        return l;
    }

    public static void main (String[] args)
    {
        String X="ABABC";
        String Y="BABCA";

        int k=X.length();
        int q=Y.length();

        System.out.println(lcs(X,Y,k,q));

    }
}