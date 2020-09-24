public class Recursively
{
    public int power(int num, int power)
    {
        if(power == 0)
        {
            return 1;
        }
        else
        {
            return num * power(num, power -1);
        }
    }
}

