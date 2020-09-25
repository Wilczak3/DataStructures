public class Recursion
{
    public int calculate(int num)
    {
        if(num == 0)
        {
            return 0;
        }
        else if(num == 1)
        {
            return 1;
        }
        else
        {
            return calculate(num - 1) + calculate(num - 2);
        }
    }
}