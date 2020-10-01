public class Recursion
{
    private int count;
    public int C(int n, int k)
    {
        if(k==0 || n==0 || k==n)
        {
            return 1;
        }
        else
        {
            return count = C(n-1,k) + C(n-1,k-1); 
        }
        
    }
}